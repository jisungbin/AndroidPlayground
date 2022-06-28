package land.sungbin.androidplayground.texttoolbar

import android.view.ActionMode
import android.view.View
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.platform.TextToolbarStatus
import land.sungbin.androidplayground.wrapper.ToastWrapper

class SungbinLandTextToolbar(private val view: View) : TextToolbar {
    private var actionMode: ActionMode? = null
    override var status = TextToolbarStatus.Hidden
        private set

    override fun showMenu(
        rect: Rect,
        onCopyRequested: (() -> Unit)?,
        onPasteRequested: (() -> Unit)?,
        onCutRequested: (() -> Unit)?,
        onSelectAllRequested: (() -> Unit)?
    ) {
        if (actionMode == null) {
            status = TextToolbarStatus.Shown
            actionMode = view.startActionMode(
                FloatingTextActionModeCallback(
                    toast = ToastWrapper(context = view.context),
                    onActionModeDestroy = {
                        actionMode = null
                    }
                ),
                ActionMode.TYPE_FLOATING
            )
        } else {
            actionMode?.invalidate()
        }
    }

    override fun hide() {
        status = TextToolbarStatus.Hidden
        actionMode?.finish()
        actionMode = null
    }
}
