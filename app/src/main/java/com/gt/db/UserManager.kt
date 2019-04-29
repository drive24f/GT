package com.gt.db

import android.content.Context
import com.gt.MainApp
import io.objectbox.Box
import io.objectbox.query.Query

class UserManager(val context: Context) {

    private var userBox: Box<UserBox> = MainApp.create(context).getBoxStore().boxFor(UserBox::class.java)
    private lateinit var userQuery: Query<UserBox>

}