package com.boni.lottonumgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        btnActNameGenerateNum.setOnClickListener {
            startActivity(Intent(this@NameActivity, ResultActivity::class.java))
        }

        btnActNameBack.setOnClickListener {
            finish()
        }
    }
}
