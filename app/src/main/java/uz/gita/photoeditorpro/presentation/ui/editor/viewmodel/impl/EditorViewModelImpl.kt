package uz.gita.photoeditorpro.presentation.ui.editor.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import uz.gita.photoeditorpro.data.Emoji
import uz.gita.photoeditorpro.presentation.ui.editor.viewmodel.EditorViewModel
import javax.inject.Inject

@HiltViewModel
class EditorViewModelImpl @Inject constructor() : EditorViewModel, ViewModel() {
    override val backBtn = MutableStateFlow(Unit)
    override val undoBtn = MutableStateFlow(Unit)
    override val redoBtn = MutableStateFlow(Unit)
    override val addEmojiFlow = MutableSharedFlow<Emoji>()

    var emojiCounter = 0

    override fun addEmoji(resEmoji: Int) {
        val emoji = Emoji(res = resEmoji, tag = emojiCounter++)
        viewModelScope.launch {
            addEmojiFlow.emit(emoji)
        }
    }
}