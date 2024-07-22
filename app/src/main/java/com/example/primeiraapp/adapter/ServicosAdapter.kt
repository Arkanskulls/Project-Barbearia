package com.example.primeiraapp.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiraapp.databinding.ServicosItemBinding
import com.example.primeiraapp.model.Servicos

class ServicosAdapter(private val context: Context, private val listaServicos: MutableList<Servicos>):
    RecyclerView.Adapter<ServicosAdapter.ServicosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicosViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ServicosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }inner class  ServicosViewHolder(binding: ServicosItemBinding): RecyclerView.ViewHolder(binding.root){

    }
}