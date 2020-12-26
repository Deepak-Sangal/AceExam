package com.acexams.aceexam.util

import android.content.Context
import android.widget.Toast

interface const {

    val IMAGE_URL: String
        get() = "http://zooneto.in/vidyahaat/public/uploads/courses/"

    val REMEBER: String
        get() = "remeber"
    val TOKEN: String
        get() = "token"
    val EMAIL: String
        get() = "email"
    val NAME: String
        get() = "name"

    val CONTENT_TYPE:String
    get() = "application/x-www-form-urlencoded"

    val USER_ID:String
    get() = "id"

    val FCM_TOKEN:String
        get() = "fcmtoken"

    val ACCESS_TOKEN:String
    get() = "access_token"

    val BEARER:String
    get() = "Bearer"

    val FIRST_NAME:String
        get() = "first_name"
    val LAST_NAME:String
        get() = "last_name"
    val DESCRIPTION:String
        get() = "description"
    val MOBILE:String
        get() = "mobile"



    fun toast(context:Context,msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}