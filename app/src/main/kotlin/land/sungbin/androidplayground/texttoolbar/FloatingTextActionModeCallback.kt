@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")
@file:NoLiveLiterals

package land.sungbin.androidplayground.texttoolbar

import android.graphics.Rect
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.compose.runtime.NoLiveLiterals
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.wrapper.ToastWrapper
import androidx.compose.ui.geometry.Rect as ComposeRect

private const val DefaultGroupId = 0
private const val SungbinLandItemId = 0

class FloatingTextActionModeCallback(
    var clickedRect: ComposeRect = ComposeRect.Zero,
    private val toast: ToastWrapper,
    private val onActionModeDestroy: () -> Unit
) : ActionMode.Callback2() {

    override fun onActionItemClicked(
        mode: ActionMode?,
        item: MenuItem?
    ): Boolean {
        requireNotNull(item)
        when (item.itemId) {
            SungbinLandItemId -> toast("SungbinLand")
        }
        mode?.finish()
        return true
    }

    override fun onCreateActionMode(
        mode: ActionMode?,
        menu: Menu?
    ): Boolean {
        requireNotNull(menu)
        menu.addSungbinLandItem()
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        if (menu == null) return false
        menu.addItemIfEmpty()
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        onActionModeDestroy()
    }

    override fun onGetContentRect(
        mode: ActionMode?,
        view: View?,
        outRect: Rect?
    ) {
        with(clickedRect) {
            outRect?.set(
                left.toInt(),
                top.toInt(),
                right.toInt(),
                bottom.toInt()
            )
        }
    }
}

private fun Menu.addSungbinLandItem() {
    this.add(DefaultGroupId, SungbinLandItemId, 0, R.string.sungbin_land)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
}

private fun Menu.addItemIfEmpty() {
    if (findItem(SungbinLandItemId) == null) {
        addSungbinLandItem()
    }
}
