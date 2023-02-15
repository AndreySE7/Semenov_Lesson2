package com.example.semenov_lesson2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.semenov_lesson2.Contract.Companion.TEXT_KEY
import com.example.semenov_lesson2.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {

    lateinit var binding: ActivityMoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val message = binding.editText.text.toString()
            val result = intent.putExtra(TEXT_KEY, message)

            when (message.isEmpty()) {
                true -> setResult(RESULT_CANCELED, result)
                false -> setResult(RESULT_OK, result)
            }
            finish()
        }
    }
}