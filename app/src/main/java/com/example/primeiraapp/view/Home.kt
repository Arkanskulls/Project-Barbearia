package com.example.primeiraapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.primeiraapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val nome = intent.extras?.getString("nome")
        binding.txtNomeUsuario.text = "Bem-Vindo Boca de Pelo,$nome"
    }
}