package com.kamiapk.animationplayground

import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //拡大
    fun scaleAnimation(view: View) {
        //アニメーションのオブジェクトの作成
        //context,xmlで記述したアニメーションが引数
        val scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)

        //ターゲットを決めてアニメーション
        scaleAnimator?.apply {
            setTarget(imageview)
            start()
        }
    }


    //回転
    fun rotateAnimation(view: View) {

        val rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(imageview)
            start()
        }
    }

    //fade out - in
    //xmlのonClickプロパティからこの関数が呼び出されるのでview(ボタン)を引数にとるが(ボタンviewは)利用しない
    fun fadeAnimation(view: View) {
        //アニメーションのオブジェクトの作成
        //context,xmlで記述したアニメーションが引数
        val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)

        /*
            fadeAnimator.setTarget(testImage)
            fadeAnimator.start()
        */

        //apply関数を使った方が記述がすっきりかける
        fadeAnimator?.apply {
            //testImageはImageView
            setTarget(imageview)
            start()
        }

    }



    //移動
    fun translateAnimation(view: View) {

        val translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator.apply {
            setTarget(imageview)
            start()
        }
    }

}