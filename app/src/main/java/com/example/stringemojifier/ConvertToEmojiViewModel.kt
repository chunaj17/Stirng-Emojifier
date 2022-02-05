package com.example.stringemojifier

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stringemojifier.network.NtkInterface
import com.example.stringemojifier.network.RetroInstance
import com.example.stringemojifier.network.User
import com.example.stringemojifier.network.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                if (response.isSuccessful) {
                    emojiWizString.postValue(response.body())
                } else {
                   binding.apply {
                       doneButton.visibility = View.GONE
                       valueText.visibility = View.GONE
                       responseText.text = response.message()
                   }
                    emojiWizString.postValue(null)
                }
            }
        })
    }
}