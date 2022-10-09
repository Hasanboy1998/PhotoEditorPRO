package uz.gita.photoeditorpro.presentation.ui.editor.pages.emoji

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.photoeditorpro.R
import uz.gita.photoeditorpro.data.Emoji
import uz.gita.photoeditorpro.databinding.PageEmojiBinding
import uz.gita.photoeditorpro.presentation.ui.editor.pages.adapter.EmojiAdapter


@AndroidEntryPoint
class EmojiPage : Fragment(R.layout.page_emoji) {
    private val viewBinding: PageEmojiBinding by viewBinding(PageEmojiBinding::bind)
    private val emojiAdapter: EmojiAdapter by lazy { EmojiAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.rvEmoji.adapter = emojiAdapter
    }
}