package com.msensis.life4lv.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.msensis.life4lv.library.databinding.ActivitySplashBinding
import com.msensis.life4lv.library.dialogs.NewFilenameDialog
import com.msensis.life4lv.library.ui.splash.SplashActivity
import kotlin.random.Random

class MainActivity : SplashActivity<MainViewModel, ActivitySplashBinding>() {


    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
}
