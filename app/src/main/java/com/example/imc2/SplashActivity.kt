package com.example.imc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        buttonSave.setOnClickListener {
            handleSave()
        }

    }

    fun handleSave() {
        val peso = textPeso.text.toString()
        val altura = textAltura.text.toString()

        if (peso != "" && altura != "") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("peso", peso)
            intent.putExtra("altura", altura)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}