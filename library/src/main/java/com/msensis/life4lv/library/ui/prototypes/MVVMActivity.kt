package com.msensis.life4lv.library.ui.prototypes

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

abstract class MVVMActivity<VM: BaseViewModel, VB: ViewDataBinding>: DataBindingActivity<VB>() {
    protected lateinit var viewModel: VM

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createViewModel()
    }

    protected open fun createViewModel()
    {
        viewModel = ViewModelProviders.of(this).get(getViewModelClass())
    }

    /**
     * @return view model class
     */
    abstract fun  getViewModelClass(): Class<VM>
}