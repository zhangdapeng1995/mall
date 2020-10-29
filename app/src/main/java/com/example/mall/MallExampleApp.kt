package com.example.mall

import android.app.Application
import global.Mall

class MallExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mall.init(this)
            .withApiHost("http://www:123.com")
            .configure()
    }
}