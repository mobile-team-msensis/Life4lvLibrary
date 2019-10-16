package com.msensis.life4lv.library.dialogs.prototypes

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.msensis.life4lv.library.R

abstract class Dialog(val context: Context) {

    private var dialog: AlertDialog? = null

    protected open fun getBuilder(): AlertDialog.Builder {
        return AlertDialog.Builder(context, R.style.AppTheme_Dialog)
    }

    protected abstract fun setUpBuilder(builder: AlertDialog.Builder): AlertDialog.Builder

    fun show(){
        if(dialog == null)
            dialog = setUpBuilder(getBuilder()).create()

        if(dialog?.isShowing == false)
            dialog?.show()
    }

    fun hide(){
        dialog?.hide()
    }
}
