package com.gt.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.gt.BaseActivity
import com.gt.MainApp
import com.gt.R
import com.gt.databinding.ActivityLoginBinding
import com.gt.ui.login.model.LoginResponse
import com.gt.ui.room.RoomActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    private lateinit var binding: ActivityLoginBinding

    companion object {
        fun create(): LoginActivity = LoginActivity()
    }

    fun start(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        (context as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.apply { binding.setPresenter = presenter }
        presenter.set(this)
    }

    override fun onLogin() {
        binding.let {
            val userName: String = it.inputUsername.text.toString()
            val password: String = it.inputPassword.text.toString()
            presenter.fetchApi(userName,password)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {
        binding.let {
            Snackbar.make(
                it.coordinator,
                "Ooops, terjadi kesalahan coba lagi",
                Snackbar.LENGTH_INDEFINITE
            ).setAction("Close") { }.show()
        }
    }

    override fun retrieve(model: LoginResponse) {
        RoomActivity.create().start(this)
    }

    override fun onBack() {
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fadeIn()
    }
}