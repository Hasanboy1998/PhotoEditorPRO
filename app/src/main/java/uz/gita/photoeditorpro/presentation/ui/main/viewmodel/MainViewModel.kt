package uz.gita.photoeditorpro.presentation.ui.main.viewmodel

import android.net.Uri
import kotlinx.coroutines.flow.Flow

interface MainViewModel {
    val openCamera: Flow<Unit>
    val openGallery: Flow<Unit>
    val openInfo: Flow<Unit>

    fun openCameraClick()
    fun openGAlleryClick()
    fun openInfoClick()
    fun openEditor(imgUri: Uri)
}