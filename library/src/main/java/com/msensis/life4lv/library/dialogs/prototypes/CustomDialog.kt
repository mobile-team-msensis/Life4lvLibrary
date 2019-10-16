package com.msensis.life4lv.library.dialogs.prototypes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog

abstract class CustomDialog(context: Context): Dialog(context) {

    private var view: View? = null

    override fun getBuilder(): AlertDialog.Builder {
        val builder = super.getBuilder()
        builder.setView(getView())
        return builder
    }

    override fun setUpBuilder(builder: AlertDialog.Builder): AlertDialog.Builder {
        return setUpBuilder(builder, view!!)
    }
    abstract fun setUpBuilder(builder: AlertDialog.Builder, view: View): AlertDialog.Builder

    protected fun getView(): View
    {
        if(view != null)
                return view!!

        var inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        view = inflater.inflate(getLayout(),  null)

        return view!!
    }

    protected abstract fun getLayout(): Int
}