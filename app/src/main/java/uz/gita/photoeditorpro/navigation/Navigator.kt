package uz.gita.photoeditorpro.navigation

import androidx.navigation.NavDirections

interface Navigator {
    suspend fun navigateTo(navDirections: NavDirections)
    suspend fun back()
}