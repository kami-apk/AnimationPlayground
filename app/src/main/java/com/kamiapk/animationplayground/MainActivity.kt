package com.kamiapk.animationplayground

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , Animator.AnimatorListener{

    /*
    XMLを用いたアニメーションのためにAnimator変数を宣言しておく
    といってもオーバーライドメソッドで利用するくらいしかなさそう?
     */
    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var fadeAnimator: Animator? = null



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        code_button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

    }


    //拡大
    fun scaleAnimation(view: View) {
        //アニメーションのオブジェクトの作成
        //context,xmlで記述したアニメーションが引数
        val scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)

        //ターゲットを決めてアニメーション
        scaleAnimator?.apply {
            setTarget(imageview)
            //このリスナでAnimator.AnimatorListenerのオーバーライドメソッドが呼び出されるようになる
            addListener(this@MainActivity)
            start()
        }
    }

    //回転
    fun rotateAnimation(view: View) {

        val rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(imageview)
            addListener(this@MainActivity)
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
            setTarget(imageview)
            addListener(this@MainActivity)
            start()
        }

    }

    //移動
    fun translateAnimation(view: View) {
        val translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator.apply {
            setTarget(imageview)
            addListener(this@MainActivity)
            start()
        }
    }


    override fun onAnimationRepeat(animation: Animator?) {
            Toast.makeText(this, "Animation Repeat", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(animation: Animator?) {
            Toast.makeText(this, "Animation End", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(animation: Animator?) {
        if(animation == translateAnimator){
            Toast.makeText(this, "Animation Cancel", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAnimationStart(animation: Animator?) {

        Toast.makeText(this, "Animation Start", Toast.LENGTH_SHORT).show()

    }


}