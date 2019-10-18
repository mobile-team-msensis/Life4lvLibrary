package com.msensis.life4lv.library.ui.prototypes

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

abstract class MVVMFActivity<VM: BaseViewModel, VB: ViewDataBinding>: MVVMActivity<VM, VB>(){

    override fun createViewModel() {
        viewModel = ViewModelProviders.of(this, getFactory()).get(getViewModelClass())
    }

    /**
     * @return layout resource id
     */
    abstract fun getFactory(): ViewModelProvider.NewInstanceFactory
}