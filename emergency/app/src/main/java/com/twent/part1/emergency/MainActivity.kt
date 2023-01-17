package com.twent.part1.emergency

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.twent.part1.emergency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goInputActivity.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        binding.deleteButton.setOnClickListener {
            deleteData()
        }

        binding.phoneLayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.phoneValueTextView.text.toString()
                    .replace("-", "")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataAndUiUpdate()
    }
    private fun getDataAndUiUpdate() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthdateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.phoneValueTextView.text = getString(EMERGENCY, "미정")
            val precautions = getString(PRECAUTIONS, "")

            binding.precautionsTextView.isVisible = precautions.isNullOrEmpty().not()
            binding.precautionsValueTextView.isVisible = precautions.isNullOrEmpty().not()
            if (!precautions.isNullOrEmpty()) {
                binding.precautionsValueTextView.text = precautions
            }
            binding.precautionsValueTextView.text = getString(PRECAUTIONS, "없음")
        }
    }

    private fun deleteData() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
            clear()
            apply()
            getDataAndUiUpdate()
        }
        Toast.makeText(this,"초기화 됐습니다.", Toast.LENGTH_SHORT ).show()
    }
}