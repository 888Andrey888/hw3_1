package com.example.hw3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btSend.setOnClickListener{
            var emailIntent = Intent(android.content.Intent.ACTION_SEND)

            emailIntent.type = "plain/text"
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf(bindingClass.etEmail.text.toString()))
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, bindingClass.etSubject.text.toString())
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, bindingClass.etMessage.text.toString())

            this.startActivity(emailIntent)
        }
    }
}