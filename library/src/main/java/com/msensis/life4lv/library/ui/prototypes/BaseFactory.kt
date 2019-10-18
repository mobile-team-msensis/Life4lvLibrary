package com.msensis.life4lv.library.ui.prototypes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFactory<T: BaseViewModel>:  ViewModelProvider.NewInstanceFactory()
{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //TST @
        return getViewModel() as T
    }

    abstract fun getViewModel(): T
}