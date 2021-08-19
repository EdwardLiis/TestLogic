package com.example.myapplication

data class DataAbout(
    val success:Boolean,
    val errors_message:String?,
    val data:Data
)

data class Data(
    val privacy_file:String,
    val about:String
)
