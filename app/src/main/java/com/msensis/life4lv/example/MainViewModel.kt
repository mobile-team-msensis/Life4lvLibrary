package com.msensis.life4lv.example

import androidx.lifecycle.ViewModel
import com.msensis.life4lv.library.ui.prototypes.BaseViewModel

class MainViewModel: BaseViewModel(){

    init {
        println("sss MainViewModel")
    }


    var counter = 0
        private set


    public fun increase(){
        counter++
    }

}