package com.xinator.livetvallchannels.api

import com.xinator.livetvallchannels.model.Channels
import retrofit2.http.GET

interface ChannelsApi {
    @GET("posts/1")
    suspend fun getChannels():Channels
}