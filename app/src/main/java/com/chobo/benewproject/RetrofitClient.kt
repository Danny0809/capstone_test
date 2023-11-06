package com.chobo.benewproject

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private val BASE_URL : String = ""//url입력
    //url : http://ec2-3-39-251-72.ap-northeast-2.compute.amazonaws.com/

    fun getApiService(): RetrofitService? {
        return getClient().create(RetrofitService::class.java)
    }

    fun getClient(): Retrofit? {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}