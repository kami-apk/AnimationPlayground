package com.kamiapk.animationplayground

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewPropertyAnimator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    /*
    XMLを用いたアニメーションのためにAnimator変数を宣言しておく
    といってもオーバーライドメソッドで利用するくらいしかなさそう?

    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var fadeAnimator: Animator? = null
    */


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        code_button.setOnClickListener {
            val intent = Intent(this, CodePropertyAnimationActivity::class.java)
            startActivity(intent)
        }

        drawable_button.setOnClickListener {
            val intent = Intent(this, DrawableActivity::class.java)
            startActivity(intent)
        }

        lottie_button.setOnClickListener {
            val intent = Intent(this, LottieActivity::class.java)
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


    fun set(view : View){
        val animator = AnimatorInflater.loadAnimator(this,R.animator.set)
        animator.apply{
            setTarget(imageview)
            start()
        }
    }

    fun bounce(view : View){
        val animator = AnimatorInflater.loadAnimator(this,R.animator.bounce)
        animator.apply{
            setTarget(imageview)
            start()
        }
    }

    /*
    viewPropertyAnimator　-> イベントに対して操作ができない(アニメーションだけ)
    propertyValuesHolder -> イベントに対して操作ができる
     */
    fun viewPropertyAnimator(view : View){
        val vpa : ViewPropertyAnimator = imageview.animate()
        vpa.apply{
            duration = 1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            //interpolator = BounceInterpolator()
            start()
        }
    }

    fun propertyValuesHolder(view : View){
        val rotateX : PropertyValuesHolder = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.5f)

        val objAnim = ObjectAnimator.ofPropertyValuesHolder(imageview, rotateX, scaleX, scaleY)
        objAnim.apply {
            duration = 1000
            //interpolator = BounceInterpolator()
            start()
        }
    }


}