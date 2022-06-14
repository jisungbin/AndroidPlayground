@file:Suppress("unused")

package land.sungbin.androidplayground.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @ViewModelScoped
    @Provides
    fun provideInt() = 1
}
