package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Contatos
import com.example.myapplication.R
import com.squareup.picasso.Picasso


class ContatosAdapter(private val contatos:List<Contatos>): RecyclerView.Adapter<ContatosAdapter.ViewHolder>()  {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNome = itemView.findViewById<TextView>(R.id.txtNome)
        val txtNumero = itemView.findViewById<TextView>(R.id.txtNumero)
        val imgContato = itemView.findViewById<ImageView>(R.id.img_contato)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contato = contatos[position]
        holder.txtNome.text = contato.nome
        holder.txtNumero.text = contato.numero
        Picasso.get().load(contato.link).into(holder.imgContato);
    }
}