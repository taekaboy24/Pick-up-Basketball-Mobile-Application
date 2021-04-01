package com.example.myapplication

//declare imports
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myproject.R


class SmsActivity : AppCompatActivity() {

    //declare variables
    val MY_PERMISSIONS_REQUEST_SEND_SMS = 0
    val MY_PERMISSIONS_REQUEST_CALL_PHONE = 1
    var phoneNo: String? = null
    var message:kotlin.String? = null
    var etPhone: EditText? = null
    var etMsg:EditText? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {//start onCreate method
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)//set contentView to activity_sms

        //declare variable b1
        val b1 =
            findViewById<View>(R.id.backToHome) as Button//button to go back to main_activity

        b1.setOnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)//on click sends back to MainActivity
            startActivity(i)//starts the activity
        }//end onClickListener


        //declare variables of text and button
        etPhone = findViewById<View>(R.id.editText) as EditText
        etMsg = findViewById<View>(R.id.editText2) as EditText
        val bSMS =
            findViewById<View>(R.id.text) as Button
        val bCall =
            findViewById<View>(R.id.call) as Button
        //set onClickListeners
        bSMS.setOnClickListener { sendSMSMessage() }
        bCall.setOnClickListener { callPhone() }
    }//end onCreateMethod

    protected fun callPhone() {//start callPhone method
        phoneNo = etPhone!!.text.toString()//initialize phoneNo
        if (ContextCompat.checkSelfPermission(//start if
                this,
                Manifest.permission.CALL_PHONE
            )//end if
            != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CALL_PHONE
                )
            ) {
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CALL_PHONE),
                    MY_PERMISSIONS_REQUEST_CALL_PHONE
                )
            }
        } else {//starts callIntent activity
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNo")
            startActivity(callIntent)
        }
    }//end callPhone method


    protected fun sendSMSMessage() {//start sendSMSMessage method
        phoneNo = etPhone!!.text.toString()
        message = etMsg!!.text.toString()
        if (ContextCompat.checkSelfPermission(//checks permission
                this,
                Manifest.permission.SEND_SMS
            )
            != PackageManager.PERMISSION_GRANTED//grants permission
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.SEND_SMS
                )
            ) {
            } else {//start else
                ActivityCompat.requestPermissions(//requests permission
                    this, arrayOf(Manifest.permission.SEND_SMS),
                    MY_PERMISSIONS_REQUEST_SEND_SMS
                )
            }//end else
        } else {//start else
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo, null, message, null, null)
            Toast.makeText(
                applicationContext, "SMS sent.",
                Toast.LENGTH_LONG).show()
        }//emd else
    }//end sendSMSMessage method

}//end class
