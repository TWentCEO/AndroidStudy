package com.twent.part1.emergency

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.twent.part1.emergency.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )

        binding.birthdateLayer.setOnClickListener {
            val listener = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.birthdateValueTextView.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(
                this,
                listener,
                2000,
                1,
                1
            ).show()
        }

        binding.precautionsCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.precautionsEditText.isVisible = isChecked
        }

        binding.precautionsEditText.isVisible = binding.precautionsCheckBox.isChecked

        binding.saveButton.setOnClickListener {
            saveData()
            finish()
        }
    }
    private fun saveData() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()) {
            putString(NAME, binding.nameEditText.text.toString())
            putString(BLOOD_TYPE, getBloodType())
            putString(EMERGENCY, binding.phoneEditText.text.toString())
            putString(BIRTHDATE, binding.birthdateValueTextView.text.toString())
            putString(PRECAUTIONS, getPrecautions())
            apply()
        }
        Toast.makeText(this,"저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType(): String {
        val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if (binding.bloodTypePlus.isChecked) "+" else "-"
        return "$bloodSign$bloodAlphabet"
    }

    private fun getPrecautions(): String {
        return if (binding.precautionsCheckBox.isChecked) binding.precautionsEditText.text.toString() else  " "
    }
}