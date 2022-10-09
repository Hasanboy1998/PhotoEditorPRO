package uz.gita.photoeditorpro.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.photoeditorpro.navigation.Navigator
import uz.gita.photoeditorpro.navigation.NavigatorDispatcher
import uz.gita.photoeditorpro.navigation.NavigatorDispatcherImpl

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {

    @Binds
    fun navigator(impl: NavigatorDispatcherImpl): Navigator

    @Binds
    fun navigatorDispatcher(impl: NavigatorDispatcherImpl): NavigatorDispatcher
}

