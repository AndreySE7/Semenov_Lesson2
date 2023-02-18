package com.example.semenov_lesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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