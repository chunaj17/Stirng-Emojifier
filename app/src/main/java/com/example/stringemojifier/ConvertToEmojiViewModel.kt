package com.example.stringemojifier

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stringemojifier.network.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.typeOf

class ConvertToEmojiViewModel : ViewModel() {
    var emojiWizString: MutableLiveData<UserResponse?> = MutableLiveData()

    fun getResult(): MutableLiveData<UserResponse?> {
        return emojiWizString
    }


    fun convertString(user: User) {
        val retroService = RetroInstance.getRetroInstance().create(NtkInterface::class.java)
        val call = retroService.convertToEmoji(user)
        call.enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                emojiWizString.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    emojiWizString.postValue(response.body())
                } else {
                    val res = response.errorBody()
                    val gson =Gson()
                    val error = gson.fromJson(res?.charStream(),UserErrror::class.java)
                    val errorData = error.error.get("value")

                    if (response.code() == 422) {
                     binding.apply {
                            doneButton.visibility = View.GONE
                            valueText.visibility = View.GONE
                          responseText.text = errorData
                        }
                    }
                  emojiWizString.postValue(null)
                }
            }
        })
    }
}