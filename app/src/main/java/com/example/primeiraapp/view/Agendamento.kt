package com.example.primeiraapp.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primeiraapp.databinding.ActivityAgendamentoBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Agendamento : AppCompatActivity() {

    private lateinit var binding: ActivityAgendamentoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var hora: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->

            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10) {
                dia = "0$dayOfMonth"
            }
            if (monthOfYear < 10){
                mes = "" + (monthOfYear + 1)
            }else{
                mes = (monthOfYear +1).toString()
            }

            data = "$dia / $mes / $year"

        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minuto: String

            if (minute < 10) {
                minuto = "0$minute"
            } else {
                minuto = minute.toString()
            }

            hora = "$hourOfDay:$minuto"

        }
        binding.timePicker.setIs24HourView(true)

        binding.btAgendar.setOnClickListener {

            val barbeiro1 = binding.barbeiro1
            val barbeiro2 = binding.barbeiro2
            val barbeiro3 = binding.barbeiro3

            when {
                hora.isEmpty() -> {
                    mensagem(it, "Coloca hora, não sou vidente", "#FF0000")

                }
                hora < "8:00" && hora > "19:00" -> {
                    mensagem(it, "FECHADO!!, tenho vida", "#FF0000")

                }
                data.isEmpty() -> {
                    mensagem(it, "Na moral coloca a data", "#FF0000")

                }
                barbeiro1.isChecked && data. isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Agendado Parça", "#FF03DAC5")

                }
                barbeiro2.isChecked && data. isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Vou cuidar muito bem de Você", "FF03DAC5")

                }
                barbeiro3.isChecked && data. isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Rapo tuto", "#FF03DAC5")

                }
                else -> {
                    mensagem(it, "Escolha um barbeiro ou ache outro canto!", "#FF03DAC5")

                }

            }
        }
    }
    private fun mensagem(view: View, mensagem: String, cor: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
}
