package com.gt.ui.message

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gt.BaseActivity
import com.gt.MainApp
import com.gt.R
import com.gt.databinding.ActivityMessageBinding
import javax.inject.Inject

class MessageActivity : BaseActivity(), MessageView {

    @Inject
    lateinit var presenter: MessagePresenter

    private lateinit var binding: ActivityMessageBinding

    companion object {
        fun create(): MessageActivity = MessageActivity()
    }

    fun start(context: Context) {
        val intent = Intent(context, MessageActivity::class.java)
        context.startActivity(intent)
        (context as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)
        binding.apply { binding.setPresenter = presenter }
        presenter.set(this)
    }

    override fun onBack() {
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fadeIn()
    }
}