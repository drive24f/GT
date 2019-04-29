package com.gt

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.gt.common.LocaleHelper

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.create().onAttach(base))
    }

    fun fadeIn() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}