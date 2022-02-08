package com.example.stringemojifier.network

import java.util.*
import kotlin.collections.HashMap

data class User(val value: String)
data class UserResponse(
    val stringEntered:String,
    val stringConvertedToEmoji: String,
)
data class UserErrror(
    val msg: String,
    val error: java.util.HashMap<String,String>
)