package com.gt.deps

import android.app.Application
import android.content.Context
import com.gt.ui.chat.ChatPresenter
import com.gt.ui.login.LoginPresenter
import com.gt.ui.message.MessagePresenter
import com.gt.ui.room.RoomPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application.applicationContext as Context
    }

    @Provides
    @Singleton
    fun provideLoginPresenter(context: Context): LoginPresenter {
        return LoginPresenter(context)
    }

    @Provides
    @Singleton
    fun provideChatPresenter(context: Context): ChatPresenter {
        return ChatPresenter(context)
    }

    @Provides
    @Singleton
    fun provideMessagePresenter(context: Context): MessagePresenter {
        return MessagePresenter(context)
    }

    @Provides
    @Singleton
    fun provideRoomPresenter(context: Context): RoomPresenter {
        return RoomPresenter(context)
    }
}