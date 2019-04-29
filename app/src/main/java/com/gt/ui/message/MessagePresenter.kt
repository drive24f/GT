package com.gt.ui.message

import android.content.Context
import com.gt.MainApp

class MessagePresenter(val context: Context) {

    private lateinit var view: MessageView

    init {
        MainApp.create(context).provides().inject(presenter = this)
    }

    fun set(view: MessageView) {
        this.view = view
    }

    fun onClickBack() {
        view.onBack()
    }
}