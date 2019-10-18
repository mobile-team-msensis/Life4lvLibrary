package com.msensis.life4lv.library.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.msensis.life4lv.library.R
import com.msensis.life4lv.library.ui.prototypes.BaseActivity
import com.msensis.life4lv.library.ui.prototypes.BaseViewModel
import com.msensis.life4lv.library.ui.prototypes.MVVMActivity

open class SplashActivity<VM: BaseViewModel, VB: ViewDataBinding>: MVVMActivity<VM, VB>()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getViewModelClass(): Class<VM> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId() = R.layout.activity_splash

    protected fun nextActivity(clazz: Class<*>) {

        startActivity(Intent(this, clazz))
        finish()
    }

    override fun onBackPressed() {

    }

}