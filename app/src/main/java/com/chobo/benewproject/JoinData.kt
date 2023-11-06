package com.chobo.benewproject

import com.google.gson.annotations.SerializedName

class JoinData {

    @SerializedName("userEmail")
    private lateinit var userEmail : String

    @SerializedName("userPassword")
    private lateinit var userPassword : String

    @SerializedName("userName")
    private lateinit var userName : String

    public fun JoinData(userEmail : String, userPassword : String, userName : String){
        this.userEmail = userEmail
        this.userPassword = userPassword
        this.userName = userName
    }

}