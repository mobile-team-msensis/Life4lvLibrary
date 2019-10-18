package com.msensis.life4lv.library.dialogs.prototypes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog

abstract class CustomDialog(context: Context): Dialog(context) {

    private var view: View? = null
    private var inflater: LayoutInflater? = null

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
        
        view = inflate().inflate(getLayout(),  null)

        return view!!
    }

    private fun inflate() = getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    protected abstract fun getLayout(): Int

    override fun clear() {
        super.clear()
        view = null
    }
}