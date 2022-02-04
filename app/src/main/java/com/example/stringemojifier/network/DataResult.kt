package com.example.stringemojifier.network

data class User(val value: String)
data class UserResponse(
    val stringEntered:String,
    val stringConvertedToEmoji: String
)