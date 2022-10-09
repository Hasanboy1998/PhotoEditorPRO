package uz.gita.photoeditorpro.presentation.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.photoeditorpro.R
import uz.gita.photoeditorpro.databinding.ScreenMainBinding
import uz.gita.photoeditorpro.presentation.ui.main.viewmodel.MainViewModel
import uz.gita.photoeditorpro.presentation.ui.main.viewmodel.impl.MainViewModelImpl


@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val viewBinding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModel.openCamera.onEach {
            ImagePicker.with(this).crop().cameraOnly().createIntent {
                startForProfileImageResult.launch(it)
            }
        }.launchIn(lifecycleScope)
        viewModel.openCamera.onEach {
            ImagePicker.with(this).crop().galleryOnly().createIntent {
                startForProfileImageResult.launch(it)
            }
        }.launchIn(lifecycleScope)

    }

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.cardCamera.clicks()
            .debounce(100)
            .onEach {
                viewModel.openCameraClick()
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewBinding.cardGallery.clicks()
            .debounce(100)
            .onEach {
                viewModel.openGAlleryClick()
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewBinding.cardInfo.clicks()
            .debounce(100)
            .onEach {
                viewModel.openInfoClick()
            }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    val fileUri = data?.data!!
                    viewModel.openEditor(fileUri)
                }
                ImagePicker.RESULT_ERROR -> {
                }
                else -> {
                }
            }
        }

}