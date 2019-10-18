package com.msensis.life4lv.example

import androidx.lifecycle.ViewModel

class MainViewModel(val test: String): ViewModel(){

    init {
        println("sss MainViewModel")
        println("sss test $test")
    }


    var counter = 0
        private set


    public fun increase(){
        counter++
    }

}