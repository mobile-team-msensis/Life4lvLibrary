package com.msensis.life4lv.library.dialogs.prototypes

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.msensis.life4lv.library.R

abstract class Dialog(private var context: Context? = null) {

    private var dialog: AlertDialog? = null

    protected open fun getBuilder(): AlertDialog.Builder {
        return AlertDialog.Builder(context!!, R.style.AppTheme_Dialog)
    }

    protected abstract fun setUpBuilder(builder: AlertDialog.Builder): AlertDialog.Builder

    private fun create(){
        dialog = setUpBuilder(getBuilder()).create()
    }

    protected fun getContext() = context!!

    fun show(){
        if(dialog == null) {
            create()
        }


        if(dialog?.isShowing == false)
            dialog?.show()
    }

    fun hide(){
        dialog?.hide()
    }

    open fun clear() {
        dialog?.dismiss()
        dialog?.cancel()
        dialog = null
        context = null
    }
}
