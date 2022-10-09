package uz.gita.photoeditorpro.presentation.ui.editor.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import uz.gita.photoeditorpro.data.Emoji

interface EditorViewModel {
    val backBtn: Flow<Unit>
    val undoBtn: Flow<Unit>
    val redoBtn: Flow<Unit>

    val addEmojiFlow: SharedFlow<Emoji>

    fun addEmoji(resEmoji: Int)
}