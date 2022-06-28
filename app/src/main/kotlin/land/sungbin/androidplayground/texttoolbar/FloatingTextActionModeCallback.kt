@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package land.sungbin.androidplayground.texttoolbar

import android.graphics.Rect
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.StringRes
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.wrapper.ToastWrapper

private const val DefaultGroupId = 0
private const val SungbinLandItemId = 0

class FloatingTextActionModeCallback(
    private val toast: ToastWrapper,
    private val onActionModeDestroy: () -> Unit
) : ActionMode.Callback2() {

    override fun onActionItemClicked(
        mode: ActionMode?,
        item: MenuItem?
    ): Boolean {
        requireNotNull(item)
        when (item.itemId) {
            SungbinLandItemId -> toast("SungbinLand clicked.")
        }
        mode?.finish()
        return true
    }

    override fun onCreateActionMode(
        mode: ActionMode?,
        menu: Menu?
    ): Boolean {
        requireNotNull(mode)
        requireNotNull(menu)
        menu.addSungbinLandItem()
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        if (mode == null || menu == null) return false
        menu.addOrRemoveItem()
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
        outRect?.set(Rect(0, 0, 0, 0))
    }
}

private fun Menu.addSungbinLandItem() {
    this.add(DefaultGroupId, SungbinLandItemId, 0, R.string.sungbin_land)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
}

private fun Menu.removeSungbinLandItem() {
    removeItem(SungbinLandItemId)
}

private fun Menu.addOrRemoveItem() {
    when (findItem(SungbinLandItemId) == null) {
        true -> addSungbinLandItem()
        else -> removeSungbinLandItem()
    }
}