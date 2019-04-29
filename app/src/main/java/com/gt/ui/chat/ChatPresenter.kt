package com.gt.ui.chat

import android.content.Context
import com.gt.MainApp

class ChatPresenter(val context: Context) {

    private lateinit var view: ChatView

    init {
        MainApp.create(context).provides().inject(presenter = this)
    }

    fun set(view: ChatView) {
        this.view = view
    }

    fun onClickBack() {
        view.onBack()
    }
}