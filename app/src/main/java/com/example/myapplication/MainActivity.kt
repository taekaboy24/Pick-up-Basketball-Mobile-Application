package com.example.myapplication

//declare imports
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myproject.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //declare variables
    var mp3: MediaPlayer? = null
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.testproject"
    private val description = "Test notification"


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {//start onCreate method
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//sets contentView to activity_main

        // declare button to navigate to new page
        val b1 =
            findViewById<View>(R.id.newPage) as Button

        b1.setOnClickListener {
            if (mp3 !=null) {//if to stop music if playing
                mp3!!.reset()
                mp3!!.stop()
            }//end if
            val i = Intent(applicationContext, PubInfo::class.java)//opens PubInfo
            startActivity(i)//starts activity

        }//end onClickListener

        //background music listener
        backgroundMusic.setOnClickListener(View.OnClickListener {
            if (mp3 != null) {//stops music if playing(prevents looping)
                mp3!!.reset()
                mp3!!.release()
            }//end if
            mp3 = MediaPlayer.create(applicationContext, R.raw.backgroundmuzic)//creates media player using file background music
            mp3!!.start()
        })//end onClickListener

        //button to stop music
        stopMusic.setOnClickListener(){
            if (mp3 !=null) {//stops music
                mp3!!.reset()
                mp3!!.stop()
            }
        }//end onClickListener

        //declare second button
        val b2 =
            findViewById<View>(R.id.camera) as Button//id as camera

        b2.setOnClickListener {
            if (mp3 !=null) {//stops music if running
                mp3!!.reset()
                mp3!!.stop()
            }
            val i = Intent(applicationContext, cameraView::class.java)//starts cameraView class
            startActivity(i)//starts class
        }


        //declares fourth button
        val b4 =
            findViewById<View>(R.id.smsButton) as Button//id button 4 as smsButton

        b4.setOnClickListener {
            if (mp3 !=null) {//stops music if running
                mp3!!.reset()
                mp3!!.stop()
            }
            val i = Intent(applicationContext, SmsActivity::class.java)//sets class to SMSActivity
            startActivity(i)//starts activity

        }//end b4

        //declare fifth button
        val b5 =
            findViewById<View>(R.id.locationCourt) as Button//id as

        b5.setOnClickListener {
            if (mp3 !=null) {//stops music if running
                mp3!!.reset()
                mp3!!.stop()
            }
            val i = Intent(applicationContext, courtLocations::class.java)//starts courtLocations class
            startActivity(i)//starts class
        }



    }//end onClickListener
}//end class
