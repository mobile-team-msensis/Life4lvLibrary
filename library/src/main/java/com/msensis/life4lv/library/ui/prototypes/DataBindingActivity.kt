package com.msensis.life4lv.library.ui.prototypes

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * Prototype activity to generate automatic view data binding.
 *
 * Just add at app gradle and at the android block the command "dataBinding { enabled = true }".
 *
 * Also add at the layout the <layout> tag like root view element
 *
 * @param VD the generate view data binding class of this activity
 */
abstract class DataBindingActivity<VD: ViewDataBinding>: BaseActivity() {

    protected lateinit var dataBinding: VD

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }


    override fun onDestroy() {
        super.onDestroy()
        dataBinding
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int
}