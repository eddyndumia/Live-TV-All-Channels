package com.xinator.livetvallchannels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xinator.livetvallchannels.model.Channels
import com.xinator.livetvallchannels.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse :MutableLiveData<Channels> = MutableLiveData()
    fun getChannel() {
        viewModelScope.launch {
        val response: Channels = repository.getChannels()
            myResponse.value = response
        }

    }
}
