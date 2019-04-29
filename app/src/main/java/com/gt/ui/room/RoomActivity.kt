package com.gt.ui.room

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gt.BaseActivity
import com.gt.MainApp
import com.gt.R
import com.gt.databinding.ActivityRoomBinding
import javax.inject.Inject

class RoomActivity : BaseActivity(), RoomView {

    @Inject
    lateinit var presenter: RoomPresenter

    private lateinit var binding: ActivityRoomBinding

    companion object {
        fun create(): RoomActivity = RoomActivity()
    }

    fun start(context: Context) {
        val intent = Intent(context, RoomActivity::class.java)
        context.startActivity(intent)
        (context as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApp.create(application).provides().inject(activity = this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room)
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