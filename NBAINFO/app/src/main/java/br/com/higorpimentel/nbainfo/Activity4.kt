package br.com.higorpimentel.nbainfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_3.*

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        supportActionBar?.title = "Lakers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerJogadores?.layoutManager = LinearLayoutManager(this)
        recyclerJogadores?.itemAnimator = DefaultItemAnimator()
        recyclerJogadores?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskJogadores()
    }

    var jogadores = listOf<Jogadores>()

    fun taskJogadores(){
        this.jogadores = JogadoresService.getJogadores()
        recyclerJogadores?.adapter = JogadoresAdapter (this.jogadores) {onClickJogadores(it)}
    }

    fun onClickJogadores(jogadores: Jogadores){

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        val id = item?.itemId
        if (id == R.id.action_sair) {
            Toast.makeText(this, "Saindo", Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else if (id == R.id.action_atualizar) {
            note_list_progress.visibility = ProgressBar.VISIBLE
            Toast.makeText(this,"Atualizando", Toast.LENGTH_LONG).show()
        }
        else if (id == R.id.action_config) {
            Toast.makeText(this,"Configurações", Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, configs::class.java)
            startActivity(intent)
        }
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }





}