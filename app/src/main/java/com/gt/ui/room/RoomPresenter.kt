package com.gt.ui.room

import android.content.Context
import com.gt.MainApp

class RoomPresenter(val context: Context) {

    private lateinit var view: RoomView

    init {
        MainApp.create(context).provides().inject(presenter = this)
    }

    fun set(view: RoomView) {
        this.view = view
    }

    fun onClickBack() {
        view.onBack()
    }
}