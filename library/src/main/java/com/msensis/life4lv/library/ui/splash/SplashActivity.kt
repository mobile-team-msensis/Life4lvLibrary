package com.msensis.life4lv.library.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.msensis.life4lv.library.R
import com.msensis.life4lv.library.ui.prototypes.BaseActivity

open class SplashActivity: BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    private fun nextActivity(clazz: Class<*>) {

        startActivity(Intent(this, clazz))
        finish()
    }

    override fun onBackPressed() {

    }

}