package com.xinator.livetvallchannels.repository

import com.xinator.livetvallchannels.api.RetrofitInstance
import com.xinator.livetvallchannels.model.Channels

class Repository {
    suspend fun getChannels():Channels{
        return RetrofitInstance.api.getChannels()
    }
}