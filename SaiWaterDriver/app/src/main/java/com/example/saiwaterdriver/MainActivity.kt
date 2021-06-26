package com.example.saiwaterdriver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.saiwaterdriver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val te = findViewById<EditText>(R.id.etUserId)
        binding.buttonLogin.setOnClickListener {

            if (binding.etUserId != null && binding.etPassword != null) {
                val intent = Intent(this, LoginWithPin::class.java)
                intent.putExtra("user",te.text.toString())
                startActivity(intent)

            }
        }


    }
}