package com.twent.part1.chapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

var number = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val plusButton = findViewById<Button>(R.id.plusButton)

        resetButton.setOnClickListener {
            number = 0
            numberTextView.text = number.toString()
            Log.d("onClick", "리셋 버튼이 클릭 됐습니다.")
        }

        plusButton.setOnClickListener {
            number++
            numberTextView.text = number.toString()
            Log.d("onClick", "플러스 된 숫자 $number")
        }

        if(savedInstanceState != null)
        {
            number = savedInstanceState.getInt("number");
            Log.d("savedInstanceState", "저장된 숫자 $number")
            numberTextView.text = number.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("savedInstanceState", "저장될 숫자 $number")
        outState.putInt("number", number)
    }
}