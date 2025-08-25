package com.depi.mvpex.model

import com.depi.mvpex.model.domain.User

class FakeDataBase {
    fun getCurrentUser(): User{
        return User("Mahmoud Hekal", 2004)
    }
}