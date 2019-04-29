package com.gt.ui.login

import com.gt.ui.login.model.LoginResponse

interface LoginView {
    fun onBack()
    fun onLogin()
    fun hideLoading()
    fun showLoading()
    fun onError()
    fun retrieve(model: LoginResponse)
}