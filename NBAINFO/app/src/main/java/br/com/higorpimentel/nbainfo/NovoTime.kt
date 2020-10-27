package br.com.higorpimentel.nbainfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_time.*

class NovoTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_time)

        botaosalvar.setOnClickListener{
            val d = Jogadores()
            d.nome = nomeJogador.text.toString()
            d.professor = professor.text.toString()
            Thread{
                JogadoresService.saveJogadores(d)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }
}