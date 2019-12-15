package com.kamiapk.animationplayground

import android.animation.AnimatorInflater
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_animated_vector.*


class AnimatedVectorActivity : ScopedAppActivity() {

    //animationのフラグ
    private var checkFlag = true
    //animationが動作中なのかを判断するフラグ
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animated_vector)
        button.setOnClickListener {
            if(isRunning == false) {
                isRunning = true
                fadeAnimation()
                if (checkFlag) {
                    checkToClose()
                } else {
                    closeToCheck()
                }
                checkFlag = !checkFlag

                //一秒間ボタンが連続タップされても何も起こらないようにする
                Handler().postDelayed(Runnable {
                    isRunning = false
                }, 1000)
            }

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
        //0.5秒×2　でfade out-inを行う
        val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.fastalpha)
        fadeAnimator?.apply {
            setTarget(button)
            start()
        }
    }

}
