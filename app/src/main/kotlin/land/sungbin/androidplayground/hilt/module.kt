@file:Suppress("unused")
// @file:NoLiveLiterals // enabled live literals for test live literals generate.

package land.sungbin.androidplayground.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    fun provideInt() = 1
}
