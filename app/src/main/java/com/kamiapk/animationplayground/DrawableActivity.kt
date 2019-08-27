package com.kamiapk.animationplayground

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_drawable.*

class DrawableActivity : AppCompatActivity() {

    //インスタンス宣言
    private lateinit var wifiAnimatiom : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)
        Log.w("TT","onCreate")

        button2.setOnClickListener {
            val intent = Intent(this, AnimatedVectorActivity::class.java)
            startActivity(intent)
        }
    }

    /*
    onCreate()ではViewを見える状態にするだけであり、Viewに動的な変化をもたらす設定は、onCreate()後に呼ばれる
    onStart()内に記述する必要がある
     */
    override fun onStart(){
        super.onStart()
        Log.w("TT","onStart")

        imageView.setBackgroundResource(R.drawable.wifi_animation)//animation-list
        wifiAnimatiom = imageView.background as AnimationDrawable
        wifiAnimatiom.start() // 一回スタートすれば繰り返しアニメーションをする



    }

    fun onClick(view : View){
        if(wifiAnimatiom.isRunning){ //start()したものはisRunningで状態が反映される
            wifiAnimatiom.stop()
            stopStart_button.setText("START")
        }else{
            wifiAnimatiom.start()
            stopStart_button.setText("STOP")
        }

    }








}
