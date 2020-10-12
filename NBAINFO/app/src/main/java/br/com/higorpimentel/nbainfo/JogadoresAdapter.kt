package br.com.higorpimentel.nbainfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JogadoresAdapter(
    val jogadores: List<Jogadores>,
    val onClick: (Jogadores) -> Unit
): RecyclerView.Adapter<JogadoresAdapter.JogadoresViewHolder>() {

    class JogadoresViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardNome: TextView

        init {
            cardNome = view.findViewById(R.id.cardNome)
        }

    }

    override fun getItemCount() = this.jogadores.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadoresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_jogadores, parent, false)

        val holder = JogadoresViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: JogadoresViewHolder, posicao: Int) {
        val jogador = this.jogadores[posicao]

        holder.cardNome.text = jogador.nome


        holder.itemView.setOnClickListener{onClick(jogador)}

    }

}
