package com.twent.part1.emergency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val message = intent.getStringExtra("intentMessage")
        Log.d("intentMessage", "onCreate: $message")
    }
}