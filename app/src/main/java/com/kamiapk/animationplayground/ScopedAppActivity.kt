package com.kamiapk.animationplayground

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class ScopedAppActivity : AppCompatActivity() , CoroutineScope by MainScope(){
    //KotlinCoroutine用のjobキャンセルを裏でやっていただく
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}