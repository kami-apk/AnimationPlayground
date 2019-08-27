package com.kamiapk.animationplayground

import android.animation.AnimatorInflater
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import kotlinx.android.synthetic.main.activity_animated_vector.*
import kotlinx.android.synthetic.main.activity_main.*


class AnimatedVectorActivity : AppCompatActivity() {

    private var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_vector)

        button.setOnClickListener {

            fadeAnimation()

            if(flag){
                Log.w("TT","bb")
                checkToClose()
            }else{
                Log.w("TT","aa")
                closeToCheck()
            }

            flag = !flag

        }
    }


    //Frame Animationと同じ手順
    private fun checkToClose(){
        imageView2.setImageResource(R.drawable.avd_anim)
        //AnimatedVectorDrawableインスタンスを取得
        val avdCheckToClose : AnimatedVectorDrawable = imageView2.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    //逆操作
    private fun closeToCheck(){
        imageView2.setImageResource(R.drawable.avd_revanim)
        //AnimatedVectorDrawableインスタンスを取得
        val avdCheckToClose : AnimatedVectorDrawable = imageView2.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    fun fadeAnimation() {

        val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.fastalpha)
        fadeAnimator?.apply {
            setTarget(button)
            start()
        }

    }

}
