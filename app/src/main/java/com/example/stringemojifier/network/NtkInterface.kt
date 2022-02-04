package com.example.stringemojifier.network

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NtkInterface {
    @POST("convertString")
    @Headers( "Content-Type:application/json")
    fun convertToEmoji(@Body requestBody: User): Call<UserResponse>
}