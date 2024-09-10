package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.Dao.ContatosDao
import com.example.myapplication.Model.Contatos
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val dao = ContatosDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastra = findViewById<Button>(R.id.btn_cadastrar)
        val edtNome= findViewById<TextInputLayout>(R.id.edt_nome)
        val edtNumero = findViewById<TextInputLayout>(R.id.edt_numero)
        val edtLink = findViewById<TextInputLayout>(R.id.edt_link)
        val verAgenda = findViewById<TextView>(R.id.ver_agenda)


        btnCadastra.setOnClickListener {
            val contato = Contatos(edtNome.getEditText()?.getText().toString(), edtNumero.getEditText()?.getText().toString(), edtLink.getEditText()?.getText().toString())
            dao.cadastraContato(contato)
            //Toast.makeText(this, "inserido com sucesso", Toast.LENGTH_SHORT).show()
//            edtNome.text.clear()
//            edtNumero.text.clear()
//            edtLink.text.clear()
        }

        verAgenda.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }
}