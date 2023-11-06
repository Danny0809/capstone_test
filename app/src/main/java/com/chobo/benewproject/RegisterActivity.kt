package com.chobo.benewproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var et_id : EditText
    private lateinit var et_password : EditText
    private lateinit var et_passwordCheck : EditText
    private lateinit var btn_next : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        et_id = findViewById(R.id.et_register_id)
        et_password = findViewById(R.id.et_register_password)
        et_passwordCheck = findViewById(R.id.et_register_passwordCheck)
        btn_next = findViewById(R.id.btn_register_next)

        btn_next.setOnClickListener {
            if(et_password.text.toString() == et_passwordCheck.text.toString()) {
                val intent = Intent(this, RegisterInfoActivity::class.java)
                intent.putExtra("account", et_id.text.toString())
                intent.putExtra("password", et_id.text.toString())
                startActivity(intent)
            }
            else {
                //비밀번호 재확인 요청
            }
        }
    }
}