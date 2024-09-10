package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.ContatosAdapter
import com.example.myapplication.Dao.ContatosDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity(R.layout.activity_main2) {
    val dao = ContatosDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("Lista", dao.obterLista().toString())
        val fabVolta = findViewById<FloatingActionButton>(R.id.fabVolta)
        val rvTarefas = findViewById<RecyclerView>(R.id.rc_tarefas)
        val contatos = dao.obterLista()
        rvTarefas.layoutManager = LinearLayoutManager(this)
        rvTarefas.adapter = ContatosAdapter(contatos)



        fabVolta.setOnClickListener {
            finish()
        }



    }
}