package com.msensis.edtrs.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.msensis.life4lv.library.R
import com.msensis.life4lv.library.ui.prototypes.BaseActivity

class SplashActivity: BaseActivity()
{

   // private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //viewModel.nextActivity.observe(this, Observer<Class<*>> {
         //   nextActivity(it)
        //})
    }

    private fun nextActivity(clazz: Class<*>) {

        startActivity(Intent(this, clazz))
        finish()
    }

    override fun onBackPressed() {

    }

}