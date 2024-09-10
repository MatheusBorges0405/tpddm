package com.example.myapplication.Dao

import com.example.myapplication.Model.Contatos


class ContatosDao {
    companion object{
        private val contatos = mutableListOf<Contatos>()
    }

    fun cadastraContato(contato: Contatos){
        contatos.add(contato)
    }

    fun obterLista():List<Contatos>{
        return contatos
    }
}