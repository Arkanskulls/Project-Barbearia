package com.example.primeiraapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiraapp.databinding.ActivityMainBinding
import com.example.primeiraapp.model.User
import com.example.primeiraapp.view.Cadastro
import com.example.primeiraapp.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        var parcelableArrayList = intent.getParcelableArrayListExtra<User>("userList")
        if (parcelableArrayList != null) {
            userList = parcelableArrayList
        }

        binding.singin.setOnClickListener {
            navegaPraCadastro(userList)
        }

        binding.btLogin.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                nome.isEmpty() -> {
                    mensagem(it, "Coloque o seu nome!")
                }

                senha.isEmpty() -> {
                    mensagem(it, "Coloque a sua senha!")
                }

                senha.length <= 5 -> {
                    mensagem(it, "A senha precisa ter pelo menos 6 caracteres")
                }

                else -> {
                    val user = userList.find { it.name == nome && it.password == senha }
                    if (user != null) {
                        navegaPraHome(nome)
                    } else {
                        mensagem(it, "Nome ou senha incorretos!")
                    }
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String) {
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navegaPraHome(nome: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)
    }

    private fun navegaPraCadastro(userList: ArrayList<User>) {
        val intent = Intent(this, Cadastro::class.java)
        intent.putParcelableArrayListExtra("userList", userList)
        startActivity(intent)
    }
}
