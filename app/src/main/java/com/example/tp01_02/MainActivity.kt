package com.example.tp01_02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editCelsius = findViewById<EditText>(R.id.editCelsius)
        val btnConverter = findViewById<Button>(R.id.buttonConvert)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnConverter.setOnClickListener {
            when {
                editCelsius != null -> {
                    val resultado = editCelsius.text.toString().toDouble() * 1.8 + 32
                    txtResultado.text = "%.2f F".format(resultado)
                }
                else -> {
                    txtResultado.text = "Digite um valor para converter!"
                }
            }
        }
    }
}