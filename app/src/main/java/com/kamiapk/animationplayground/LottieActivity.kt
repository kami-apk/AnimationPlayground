package com.kamiapk.animationplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lottie.*
import android.animation.ValueAnimator
import com.airbnb.lottie.LottieDrawable.INFINITE


class LottieActivity : AppCompatActivity() {

    private var animProgress = 0f
    private var isPanda = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.addUpdateListener { animation -> lottieAnimationView.progress = animation.animatedValue as Float }

        //一回切りの起動
        lottie_anim_button.setOnClickListener {
            lottieAnimationView.playAnimation()
        }

        lottie_anim_cancel.setOnClickListener {
            lottieAnimationView.cancelAnimation()
            //progressが0なら初期状態,1なら終了状態
            lottieAnimationView.progress = 1f
        }

        //需要があるかはわからないけれどもanimationの停止ができる
        suspend_Button.setOnClickListener {
            //以下の変数が必要
            //private var animProgress = 0f

            //lottieAnimationView.isAnimatingを用いればアニメーションが起動中かどうかのチェックができる
            animProgress = lottieAnimationView.progress

            if (lottieAnimationView.isAnimating){
                suspend_Button.text = "STOP"
                lottieAnimationView.cancelAnimation()
            }else{
                suspend_Button.text = "START"
                lottieAnimationView.playAnimation()
            }

            lottieAnimationView.progress = animProgress
        }

        change_button.setOnClickListener {
            //animationを別のアニメーションに切り替える
            if(!isPanda){
                lottieAnimationView.setAnimation(R.raw.panda)
                isPanda = true
            }else{
                lottieAnimationView.setAnimation(R.raw.loading_animation)
                isPanda = false
            }
            lottieAnimationView.playAnimation()
        }

        loop_button.setOnClickListener {
            //repeatCountを制御することでloopの制御ができる
            if ( lottieAnimationView.repeatCount == INFINITE ){
                lottieAnimationView.repeatCount = 0
                loop_button.text = ""
            }else{
                lottieAnimationView.repeatCount = INFINITE
                loop_button.text = "LOOP"

            }
        }
        
    }

}
