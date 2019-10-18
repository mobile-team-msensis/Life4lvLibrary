package com.msensis.life4lv.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.msensis.life4lv.library.dialogs.NewFilenameDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("sss onCreate")
        setContentView(R.layout.activity_main)
        val factory = MainFactory("${Random.nextInt(0, 100)}")
        println("sss factory $factory")
        if(savedInstanceState == null)
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel::class.java)
        else
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        println("sss viewModel $viewModel")

        println("sss ${viewModel.counter}")


    }

    override fun onBackPressed() {
        viewModel.increase()
        println("sss ${viewModel.counter}")
    }
}
