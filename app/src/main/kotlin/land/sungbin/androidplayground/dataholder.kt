@file:Suppress("unused")

package land.sungbin.androidplayground

import android.os.Parcelable
import androidx.compose.runtime.NoLiveLiterals
import kotlinx.parcelize.Parcelize

@Parcelize
data class IntHolder(var value: Int) : Parcelable
