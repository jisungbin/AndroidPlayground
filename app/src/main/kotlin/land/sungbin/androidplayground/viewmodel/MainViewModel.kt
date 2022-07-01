@file:NoLiveLiterals

package land.sungbin.androidplayground.viewmodel

import androidx.compose.runtime.NoLiveLiterals
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel()
