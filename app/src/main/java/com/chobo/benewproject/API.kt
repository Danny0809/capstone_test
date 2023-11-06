package com.chobo.benewproject

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.POST

public interface API {
    @POST("/register")
    fun getLoginResponse(@Body user: SignUpData): Call<String>
}