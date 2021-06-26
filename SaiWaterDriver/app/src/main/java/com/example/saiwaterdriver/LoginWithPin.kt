package com.example.saiwaterdriver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.saiwaterdriver.databinding.ActivityLoginWithPinBinding
import com.example.saiwaterdriver.databinding.ActivityMainBinding

class LoginWithPin : AppCompatActivity() {

    lateinit var binding: ActivityLoginWithPinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_with_pin)

        binding = ActivityLoginWithPinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvUserId.text = intent.getStringExtra("user").toString()
        Toast.makeText(this, "Welcome Back", Toast.LENGTH_SHORT).show()
        val te = findViewById<Button>(R.id.buttonContinue)


        te.setOnClickListener {

            if (binding.etPin.equals("123456")) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }

        }


    }
}