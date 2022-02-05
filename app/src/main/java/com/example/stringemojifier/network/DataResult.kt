package com.example.stringemojifier.network

data class User(val value: String)
data class UserResponse(
    val stringEntered:String,
    val stringConvertedToEmoji: String,
    val error: List<Error>,
    val msg: String
)
data class Error(
    val location: String,
    val msg: String,
    val `param`: String,
    val value: String
)