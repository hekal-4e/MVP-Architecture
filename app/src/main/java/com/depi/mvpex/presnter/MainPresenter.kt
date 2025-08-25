package com.depi.mvpex.presnter

import com.depi.mvpex.repository.MainRepository
import com.depi.mvpex.ui.IMainView

class MainPresenter {
    lateinit var view: IMainView
    private val repository = MainRepository()

    fun getUserInfo() {
        val result = repository.getCurrentUser()
        view.onUserInfoSuccess(result)
    }

    fun getWisdom() {
        val result = repository.getRandomWisdom()
        view.onWisdomSuccess(result)
    }

}