package com.msensis.life4lv.library.dialogs

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.msensis.life4lv.library.R
import com.msensis.life4lv.library.dialogs.prototypes.Dialog

class ConfirmForBackPressDialog(context: Context): Dialog(context) {

    override fun setUpBuilder(builder: AlertDialog.Builder): AlertDialog.Builder{
        builder.setTitle(R.string.exit)
        builder.setMessage(R.string.exit_message)
        builder.setPositiveButton(R.string.YES) { _, _ ->
            listener?.onExitListener()
        }

        builder.setNegativeButton(R.string.NO, null)

        return builder
    }

    var listener: OnExitListener? = null
    fun onExitListener(listener: OnExitListener?){
        this.listener = listener
    }

    interface OnExitListener
    {
        fun onExitListener()
    }
}


