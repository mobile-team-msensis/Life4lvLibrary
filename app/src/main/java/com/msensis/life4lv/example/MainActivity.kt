package com.msensis.life4lv.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.msensis.life4lv.library.dialogs.NewFilenameDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onBackPressed() {
        //NewFilenameDialog(this).show()

    }
}
