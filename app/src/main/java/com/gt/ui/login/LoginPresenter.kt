package com.gt.ui.login

import android.content.Context
import com.gt.MainApp
import com.gt.api.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class LoginPresenter(val context: Context) {

    @Inject
    lateinit var api: ApiService

    private lateinit var view: LoginView
    private var dispose : Disposable

    init {
        MainApp.create(context).provides().inject(presenter = this)
        this.dispose = Disposables.empty()
    }

    fun set(view: LoginView) {
        this.view = view
    }

    fun fetchApi(username: String, password: String) {
        dispose = api.fetchLogin(username, password)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { view.showLoading() }
            .doAfterTerminate { }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.retrieve(it) }, { catchError(it) })
    }

    private fun catchError(e: Throwable) {
        when (e) {
            is UnknownHostException -> view.onError()
            is retrofit2.HttpException -> view.onError()
            is SocketTimeoutException -> view.onError()
            is IOException -> view.onError()
            is HttpException -> view.onError()
        }
    }

    fun dispose() {
        when {
            !dispose.isDisposed -> dispose.dispose()
        }
    }

    fun onClickBack() {
        view.onBack()
    }

    fun onClickLogin() {
        view.onLogin()
    }
}