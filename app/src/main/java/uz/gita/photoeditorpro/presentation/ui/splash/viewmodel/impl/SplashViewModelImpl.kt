package uz.gita.photoeditorpro.presentation.ui.splash.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.photoeditorpro.presentation.ui.splash.viewmodel.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(): SplashViewModel, ViewModel() {
    init {
        viewModelScope.launch {
            delay(2000)

        }
    }
}