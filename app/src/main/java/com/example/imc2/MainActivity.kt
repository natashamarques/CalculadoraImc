package com.example.imc2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    fun setupView() {
        textImc.text = calcularImc().toString()
        textInfo.text = classificarImc()
        textInfo.setTextColor(classificarCor())
    }

    fun calcularImc() : Double {
        val peso = intent.getStringExtra("peso").toDouble()
        val altura = intent.getStringExtra("altura").toDouble()
        val imc = peso /(altura * altura)
        return imc
    }

    fun classificarImc() : String {
        val imc = calcularImc()
        if (imc < 18.5) {
            return "Magreza"
        } else if (imc < 24.9) {
            return "Normal"
        } else if (imc < 29.9) {
            return "Sobrepeso"
        } else if (imc < 39.9) {
            return "Obesidade"
        } else {
            return "Obesidade Grave"
        }
    }

    fun classificarCor() : Int {
        val imc = calcularImc()
        if (imc < 18.5) {
            return Color.YELLOW
        } else if (imc < 24.9) {
            return Color.GREEN
        } else if (imc < 29.9) {
            return Color.YELLOW
        } else if (imc < 39.9) {
            return Color.RED
        } else {
            return Color.RED
        }
    }


}