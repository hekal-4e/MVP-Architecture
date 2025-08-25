package com.depi.mvpex.ui

import com.depi.mvpex.model.domain.User
import com.depi.mvpex.model.domain.Wisdom

interface IMainView {
    fun onUserInfoSuccess(user: User)
    fun onWisdomSuccess(wisdom: Wisdom)
}