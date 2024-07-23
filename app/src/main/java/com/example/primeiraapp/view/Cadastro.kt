package com.example.primeiraapp.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiraapp.MainActivity
import com.example.primeiraapp.databinding.ActivityCadastroBinding
import com.example.primeiraapp.model.User
import com.google.android.material.snackbar.Snackbar

class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        var parcelableArrayList = intent.getParcelableArrayListExtra<User>("userList")

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
                    if (parcelableArrayList == null)
                        parcelableArrayList = ArrayList()

                    parcelableArrayList!!.add(User(name = nome, password = senha))
                    navegarParaLogin(parcelableArrayList!!)
                }
            }
        }
    }

    private fun navegarParaLogin(userList: ArrayList<User>) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putParcelableArrayListExtra("userList", userList)
        startActivity(intent)
        finish()
    }

    private fun mensagem(view: View, mensagem: String) {
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
}
