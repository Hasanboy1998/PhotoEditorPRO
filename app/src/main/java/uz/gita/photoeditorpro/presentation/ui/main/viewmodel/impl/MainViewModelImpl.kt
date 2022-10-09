package uz.gita.photoeditorpro.presentation.ui.main.viewmodel.impl

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.photoeditorpro.navigation.Navigator
import uz.gita.photoeditorpro.presentation.ui.main.MainScreenDirections
import uz.gita.photoeditorpro.presentation.ui.main.viewmodel.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(val navigator: Navigator) : MainViewModel, ViewModel() {
    override val openCamera = MutableStateFlow<Unit>(Unit)
    override val openGallery = MutableStateFlow<Unit>(Unit)
    override val openInfo = MutableStateFlow<Unit>(Unit)
    override fun openCameraClick() {
        viewModelScope.launch {
            openCamera.emit(Unit)
        }
    }

    override fun openGAlleryClick() {
        viewModelScope.launch {
            openCamera.emit(Unit)
        }
    }

    override fun openInfoClick() {

    }

    override fun openEditor(imgUri: Uri) {
        viewModelScope.launch {
            navigator.navigateTo(MainScreenDirections.actionMainScreenToEditorScreen(imgUri))
        }
    }
}