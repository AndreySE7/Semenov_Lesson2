package com.example.semenov_lesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class Contract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, MoveActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode == Activity.RESULT_OK) return null
        return intent?.extras?.getString(TEXT_KEY)
    }

    companion object {
        const val TEXT_KEY = "TEXT_KEY"
    }
}