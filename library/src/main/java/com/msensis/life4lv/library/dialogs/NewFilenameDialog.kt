package com.msensis.life4lv.library.dialogs

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.msensis.life4lv.library.R
import com.msensis.life4lv.library.dialogs.prototypes.CustomDialog


open class NewFilenameDialog(context: Context): CustomDialog(context)
{
    private var editText: EditText? = null

    override fun getLayout() = R.layout.dialog_edittext

    override fun setUpBuilder(builder: AlertDialog.Builder, view: View): AlertDialog.Builder{
        editText = view.findViewById(R.id.editText)
        editText?.setHint(R.string.defaultNname)

        builder.setTitle(R.string.filename)
        builder.setPositiveButton(R.string.Create) { _, _ ->
            var filename: String = getText()
            if( filename == null || filename == "")
                filename = editText?.hint.toString()

//            if(filename == null || filename == "null" || filename == "")
//              listener?.onCreateNewFilenameClickListener("")
//             else
//              listener?.onCreateNewFilenameClickListener(filename)
        }

        builder.setNegativeButton(R.string.Cancel) { _, _-> }

        return builder
    }

    protected fun getText() = editText?.text.toString().trim()




//
//    override fun getLayout(): Int {
//        R.layout.dialog_edittext
//    }
//
//    override fun create(builder: AlertDialog.Builder): AlertDialog {
//        builder.setTitle( R.string.filename)
//
//
//        return builder.create()
//    }

//    private var listener: OnCreateClickListener? = null
//    private var editText: EditText? = null

//    override fun onCreateDialog() {
//        super.onCreateDialog()
//        editText = getView().findViewById(R.id.editText)
//        builder.setPositiveButton(
//            context.getString(R.string.Create)
//        ) { _, _ ->
//            var filename: String = editText?.text.toString().trim()
//            if( filename == null || filename == "")
//                filename = editText?.hint.toString()
//
//            if(filename == null || filename == "null" || filename == "")
//                listener?.onCreateNewFilenameClickListener("")
//            else
//                listener?.onCreateNewFilenameClickListener(filename)
//        }
//
//        builder.setNegativeButton(
//            context.getString(R.string.Cancel)
//        ) { _, _->
//
//        }
//
//    }

//    override fun create(builder: AlertDialog.Builder): AlertDialog {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    fun setDefaultName(name: String)
//    {
//        editText?.hint = name
//    }
//
//    fun setDefaultName(resourceName: Int)
//    {
//        editText?.setHint(resourceName)
//    }
//
//    override fun getLayout(): Int {
//       return R.layout.dialog_edittext
//    }
//
//
//    fun setListener(listener: OnCreateClickListener)
//    {
//        this.listener = listener
//    }
//
//    interface OnCreateClickListener{
//
//        fun onCreateNewFilenameClickListener(name: String)
//    }
}