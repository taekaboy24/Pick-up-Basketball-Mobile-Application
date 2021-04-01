package com.example.myapplication

//imports
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.myproject.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {//Start Class

    override fun onCreate(savedInstanceState: Bundle?) {//start onCreate method
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)//sets viewer to activity_spalash (splashscreen


        //SPLASH SCREEN ANIMATIONS
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)//Overrides the pending transitions with fade_in fade_out
        iv_logo2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in))//starts the splash_in animation for text

        Handler().postDelayed({//Delays the drop off of splash screen by time in milliseconds
            iv_logo2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))//plays the splash_out animation for text
            Handler().postDelayed({//Delays the disappearance of logo by time in milliseconds
                iv_logo2.visibility = View.GONE// hides text
                startActivity(Intent(this, MainActivity::class.java))//starts main activity
                finish()//finishes
            },500)//delayed by 500 milliseconds
        },2500)//delayed by 2500 milliseconds


    }//end onCreate Method

}//end class