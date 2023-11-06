package com.chobo.benewproject

class SignUpResponse {

    private lateinit var code : Int
    private lateinit var message : String

    fun getCode() : Int {
        return code
    }

    fun getMessage() : String {
        return message
    }
}