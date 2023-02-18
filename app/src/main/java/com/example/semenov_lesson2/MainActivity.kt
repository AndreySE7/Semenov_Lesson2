package com.example.semenov_lesson2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.semenov_lesson2.Contract.Companion.KEY
import com.example.semenov_lesson2.Contract.Companion.TEXT_KEY
import com.example.semenov_lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val intent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivityForResult(intent, KEY)
            val message = intent.getStringExtra(TEXT_KEY)

            if (message != null) {
                if (message.isEmpty())
                    binding.textView.text = message
            } else {
                binding.textView.text = getString(R.string.defaultText)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == KEY && resultCode == RESULT_OK && data != null) {
            binding.textView.text = data.getStringExtra(TEXT_KEY)
        }
    }
}