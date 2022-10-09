package uz.gita.photoeditorpro.presentation.ui.editor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.photoeditorpro.presentation.ui.editor.pages.CropPage
import uz.gita.photoeditorpro.presentation.ui.editor.pages.emoji.EmojiPage
import uz.gita.photoeditorpro.presentation.ui.editor.pages.FilterPage
import uz.gita.photoeditorpro.presentation.ui.editor.pages.TextPage

class PageAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CropPage()
            1 -> EmojiPage()
            2 -> FilterPage()
            else -> TextPage()
        }
    }
}