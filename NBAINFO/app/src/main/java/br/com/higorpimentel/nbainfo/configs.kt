package br.com.higorpimentel.nbainfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class configs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configs)

        supportActionBar?.title = "Configurações"

    }
}