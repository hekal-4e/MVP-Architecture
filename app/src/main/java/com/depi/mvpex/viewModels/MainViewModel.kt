package com.depi.mvpex.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.depi.mvpex.model.domain.User
import com.depi.mvpex.model.domain.Wisdom
import com.depi.mvpex.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    private val _wisdom = MutableLiveData<Wisdom>()
    val wisdom: LiveData<Wisdom>
        get() = _wisdom


    fun getUserInfo() = _currentUser.postValue(repository.getCurrentUser())

    fun getWisdom() = _wisdom.postValue(repository.getRandomWisdom())
}