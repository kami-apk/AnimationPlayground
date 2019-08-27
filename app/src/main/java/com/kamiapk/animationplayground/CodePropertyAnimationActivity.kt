package com.kamiapk.animationplayground

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sub.*


//Animation using code
class CodePropertyAnimationActivity : AppCompatActivity() {

    private var rotateObjectAnimator: ObjectAnimator? = null
    private var translateObjectAnimator: ObjectAnimator? = null
    private var scaleObjectAnimator: ObjectAnimator? = null
    private var fadeObjectAnimator: ObjectAnimator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }

    //XMLで記述していたこととほぼ同じ
    fun rotateAnimation(view: View) {
        //ObjectAnimatorクラスのofFloatメソッドでインスタンスを取得
        //prppertyNameによってどんなアニメーションなのかを宣言
        rotateObjectAnimator = ObjectAnimator.ofFloat(imageview, "rotation", 0.0f, -180.0f)

        rotateObjectAnimator?.apply {

            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            //インターフェイスメソッドを導入する場合は必要
            //addListener(this@SubActivity)
            start()
        }
    }



    fun scaleAnimation(view: View) {

        scaleObjectAnimator = ObjectAnimator.ofFloat(imageview, "scaleX", 1.0f, 3.0f)
        scaleObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    fun translateAnimation(view: View) {

        translateObjectAnimator = ObjectAnimator.ofFloat(imageview, "translationX", 0f, 200f)
        translateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    fun fadeAnimation(view: View) {

        fadeObjectAnimator = ObjectAnimator.ofFloat(imageview, "alpha", 1.0f, 0.0f)
        fadeObjectAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }


    fun set(view : View) {

        //Root Animator Setとして、Child Animator SetまでRootに属するアニメーション
        //AnimatorSet()でインスタンスを取得
        //最後に関係性を
        val rootSet = AnimatorSet()
        // Flip Animation
        val flip = ObjectAnimator.ofFloat(imageview, "rotationX", 0.0f, 360.0f)
        flip.duration = 500



        // Child Animator Set
        val childSet = AnimatorSet()
        // Scale Animations
        val scaleX = ObjectAnimator.ofFloat(imageview, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        val scaleY = ObjectAnimator.ofFloat(imageview, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500


        //関係性を記述する
        //可変長引数なので割と選択の幅が広い
        //rootSet.playSequentially(flip,childSet)
        //childSet.playTogether(scaleX,scaleY)

        //関係性の記述にはいくつかの書き方がある
        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)

        //最後にアニメーションの開始
        rootSet.start()

    }




}

