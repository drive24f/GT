package com.gt.ui.chat

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gt.BaseActivity
import com.gt.MainApp
import com.gt.R
import com.gt.databinding.ActivityChatBinding
import javax.inject.Inject

class ChatActivity : BaseActivity(), ChatView {

    @Inject
    lateinit var presenter: ChatPresenter

    private lateinit var binding: ActivityChatBinding

    companion object {
        fun create(): ChatActivity = ChatActivity()
    }

    fun start(context: Context) {
        val intent = Intent(context, ChatActivity::class.java)
        context.startActivity(intent)
        (context as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
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