package com.msensis.life4lv.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msensis.life4lv.library.dialogs.NewFilenameDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("sss $this")
        println("sss ${this.baseContext}")
        println("sss ${this.applicationContext}")


    }

    override fun onBackPressed() {
        NewFilenameDialog(this.baseContext).show()

    }
}
