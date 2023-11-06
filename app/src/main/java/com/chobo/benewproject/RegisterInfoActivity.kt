package com.chobo.benewproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterInfoActivity : AppCompatActivity() {

    private lateinit var btn_join : Button
    private lateinit var et_name : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_info)

        btn_join = findViewById(R.id.btn_registerInfo_join)
        et_name = findViewById(R.id.et_registerInfo_name)

        btn_join.setOnClickListener {
            if(et_name.text.toString().isNotEmpty()){

                val prevIntent : Intent = getIntent()
                var account : String
                var password : String

                account = prevIntent.getStringExtra("account").toString()
                password = prevIntent.getStringExtra("password").toString()


            }
        }
    }
}