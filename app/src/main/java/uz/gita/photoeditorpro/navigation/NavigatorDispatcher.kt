package uz.gita.photoeditorpro.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow

typealias NavigationArgs = NavController.() -> Unit

interface NavigatorDispatcher {
    val dispatcher: Flow<NavigationArgs>
}