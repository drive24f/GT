package com.gt

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.gt.common.LocaleHelper
import com.gt.db.MyObjectBox
import com.gt.deps.ApiModule
import com.gt.deps.AppComponents
import com.gt.deps.AppModule
import com.gt.deps.DaggerAppComponents
import io.fabric.sdk.android.Fabric
import io.objectbox.BoxStore

@Suppress("DEPRECATION")
class MainApp: Application() {

    private var mainApp: MainApp = this@MainApp
    private lateinit var appComponents: AppComponents
    private lateinit var boxStore: BoxStore

    companion object {

        const val DEFAULT_LANGUAGE: String = "en"

        @Synchronized
        fun create(context: Context?): MainApp {
            return context?.applicationContext as MainApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        MultiDex.install(mainApp)
        setAppComponents()
        setObjectBox()
    }

    fun provides(): AppComponents {
        return appComponents
    }

    fun getBoxStore(): BoxStore {
        return boxStore
    }

    private fun setObjectBox() {
        boxStore = MyObjectBox.builder()
            .androidContext(mainApp)
            .build()
    }

    private fun setAppComponents() {
        this.appComponents = DaggerAppComponents.builder()
            .appModule(AppModule(mainApp))
            .apiModule(ApiModule())
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.create().onAttach(base, DEFAULT_LANGUAGE))
    }

}