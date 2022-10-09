package uz.gita.photoeditorpro.presentation.ui.editor.pages.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.photoeditorpro.R
import uz.gita.photoeditorpro.databinding.EmojiRvItemBinding
import uz.gita.photoeditorpro.presentation.ui.editor.pages.emoji.EmojiSource
import uz.gita.photoeditorpro.utils.EventBass
import uz.gita.photoeditorpro.utils.inflate

class EmojiAdapter : RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {

    private val list = EmojiSource.emojiList

    inner class EmojiViewHolder(val binding: EmojiRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.imgEmoji.setOnClickListener {
                EventBass.emojiBassLiveData.value = list[absoluteAdapterPosition]
            }
        }

        fun bind() {
            binding.imgEmoji.setImageResource(list[absoluteAdapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder =
        EmojiViewHolder(EmojiRvItemBinding.bind(parent.inflate(R.layout.emoji_rv_item)))

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = list.size
}
