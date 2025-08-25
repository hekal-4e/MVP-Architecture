package com.depi.mvpex.repository

import com.depi.mvpex.model.FakeApiService
import com.depi.mvpex.model.FakeDataBase

class MainRepository {
    private val api = FakeApiService()
    private val dataBase = FakeDataBase()

    fun getCurrentUser() = dataBase.getCurrentUser()
    fun getRandomWisdom() = api.getRandomWisdom()
}