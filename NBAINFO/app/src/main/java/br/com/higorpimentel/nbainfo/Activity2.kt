package br.com.higorpimentel.nbainfo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_3.*
import kotlinx.android.synthetic.main.toolbar.*

class Activity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val professor = Prefs.getString("professor")
        Toast.makeText(this, professor, Toast.LENGTH_LONG).show()

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

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Times"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar_view,
            R.string.nav_abrir,
            R.string.nav_fechar

        )

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_warriors -> {
                val intent: Intent = Intent(this, Activity3::class.java)
                startActivity(intent)

            }
            R.id.nav_lakers -> {
                val intent: Intent = Intent(this, Activity4::class.java)
                startActivity(intent)

            }
            R.id.nav_heat -> {
                val intent: Intent = Intent(this, Activity5::class.java)
                startActivity(intent)

            }
            R.id.sair_da_tela -> {
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_localizacao -> {
                val intent: Intent = Intent(this, MapasActivity::class.java)
                startActivity(intent)
            }

        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true

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

        else if (id == R.id.action_nova){
            val intent: Intent = Intent(this, NovoTime::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }



}