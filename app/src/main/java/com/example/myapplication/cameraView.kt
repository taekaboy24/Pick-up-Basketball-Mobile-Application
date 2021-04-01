package com.example.myapplication

//imports
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myproject.R

class cameraView : AppCompatActivity() {//start class

    //declare variables
    val REQUEST_VIDEO_RECORD = 1
    val PERMISSION_REQUEST_VIDEO_RECORD = 2
    var gg: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {//start onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_view)//sets contentView to activity_camera_view

        gg = findViewById<View>(R.id.videoView) as VideoView//initializing vv
        val mediaController = MediaController(this)//declare variable
        mediaController.setAnchorView(gg)//sets media controller to vv
        //specify the location of media file

        //Setting MediaController and URI, then starting the videoView
        gg!!.setMediaController(mediaController)

        val b3 =
            findViewById<View>(R.id.camera) as Button//id button as b3
        b3.setOnClickListener { recordVideo() }
    }//end onCreate

    private fun recordVideo() {//start recordVideo method
        if (ContextCompat.checkSelfPermission(//start if to check permission
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED//permission granted
        ) {
            ActivityCompat.requestPermissions(//requests permission
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_REQUEST_VIDEO_RECORD
            )
        } else {
            recordVideoIntent()
        }
    }

    private fun recordVideoIntent() {//start recordVideoIntent method
        val i = Intent(MediaStore.ACTION_VIDEO_CAPTURE)//declare variable i
        if (i.resolveActivity(packageManager) != null) {//start if
            startActivityForResult(i, REQUEST_VIDEO_RECORD)//starts activity based on result
        }//end if
    }

    //Attempted result to request video
    internal fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_VIDEO_RECORD && resultCode == Activity.RESULT_OK) {
            val uri = data.data
            gg!!.setVideoURI(uri)
            gg!!.start()
        }

    }
}
