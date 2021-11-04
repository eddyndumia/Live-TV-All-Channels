package com.xinator.livetvallchannels.api


import com.xinator.livetvallchannels.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ChannelsApi by lazy {
        retrofit.create(ChannelsApi::class.java)
    }
}