package com.example.mall

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import global.GlobalKeys
import global.Mall

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Mall.getConfiguration<Boolean>(GlobalKeys.IS_CONFIG_READY)
    }
}