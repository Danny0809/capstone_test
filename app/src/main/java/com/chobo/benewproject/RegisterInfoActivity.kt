package com.chobo.benewproject

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class RegisterData (
    @SerializedName("account")
    private var account: String,

    @SerializedName("password")
    private var password: String,

    @SerializedName("name")
    private var name: String
){
    override fun toString() : String{
        return "account=$account, password=$password, name=$name"
    }
}

interface DoRegister{
    @POST("register")
    fun signup(@Body request: RegisterData): Call<Boolean>
}

class RegisterInfoActivity : AppCompatActivity() {

    private lateinit var btn_join : Button
    private lateinit var et_name : EditText
    private lateinit var et_phone : EditText
    private lateinit var et_nickname : EditText
    private lateinit var et_email : EditText
    private lateinit var btn_birthdate : Button
    private lateinit var spn_gender : Spinner
    private lateinit var spn_major : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_info)

        btn_join = findViewById(R.id.btn_registerInfo_join)
        et_name = findViewById(R.id.et_registerInfo_name)
        et_phone = findViewById(R.id.et_registerInfo_phone)
        et_nickname = findViewById(R.id.et_registerInfo_nickname)
        et_email = findViewById(R.id.et_registerInfo_email)
        btn_birthdate = findViewById(R.id.btn_registerInfo_birthdate)
        spn_gender = findViewById(R.id.spn_registerInfo_gender)
        spn_major = findViewById(R.id.spn_registerInfo_major)

        et_phone.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        btn_join.setOnClickListener {

            var name = et_name.text.toString()

            if(name.isNotEmpty()){

                val retrofit = Retrofit.Builder()
                    .baseUrl("http://ec2-3-39-251-72.ap-northeast-2.compute.amazonaws.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                //http://ec2-3-39-251-72.ap-northeast-2.compute.amazonaws.com/ 주소

                val apiService = retrofit.create(DoRegister::class.java)

                val prevIntent : Intent = getIntent()
                var account : String
                var password : String

                account = prevIntent.getStringExtra("account").toString()
                password = prevIntent.getStringExtra("password").toString()

                val request = RegisterData(account, password, name)

                val call = apiService.signup(request)

                val intent = Intent(this, LoginActivity::class.java)

                call.enqueue(object : Callback<Boolean> {
                    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        if (response.isSuccessful) {
                            startActivity(intent)
                            finish()
                        } else {

                        }
                    }

                    override fun onFailure(call: Call<Boolean>, t: Throwable) {

                    }

                    })

                }
        }
    }
}