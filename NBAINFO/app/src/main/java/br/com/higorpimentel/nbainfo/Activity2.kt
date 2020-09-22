package br.com.higorpimentel.nbainfo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_3.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        botaozinho2.setOnClickListener {
            val intent: Intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        botaozinho3.setOnClickListener {
            val intent: Intent = Intent(this, Activity4::class.java)
            startActivity(intent) }

        botaozinho4.setOnClickListener {
            val intent: Intent = Intent(this, Activity5::class.java)
            startActivity(intent) }


        supportActionBar?.title = "Times"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
            barrinha.visibility = ProgressBar.VISIBLE
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