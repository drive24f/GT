package com.gt.deps

import com.gt.ui.chat.ChatActivity
import com.gt.ui.chat.ChatPresenter
import com.gt.ui.login.LoginActivity
import com.gt.ui.login.LoginPresenter
import com.gt.ui.message.MessageActivity
import com.gt.ui.message.MessagePresenter
import com.gt.ui.room.RoomActivity
import com.gt.ui.room.RoomPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponents {

    fun inject(activity: ChatActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: MessageActivity)
    fun inject(activity: RoomActivity)

    fun inject(presenter: ChatPresenter)
    fun inject(presenter: LoginPresenter)
    fun inject(presenter: MessagePresenter)
    fun inject(presenter: RoomPresenter)
}