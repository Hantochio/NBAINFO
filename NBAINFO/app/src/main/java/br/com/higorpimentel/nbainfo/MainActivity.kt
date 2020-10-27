package br.com.higorpimentel.nbainfo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoUsuario.setText(Prefs.getString("lembrarNome"))
        campoSenha.setText(Prefs.getString("lembrarSenha"))
        checkLembrar.isChecked = Prefs.getBoolean("lembrar")




        botaozinho.setOnClickListener {
            val valorUsuario = campoUsuario.text.toString()
            val valorSenha = campoSenha.text.toString()

            Prefs.setBoolean("lembrar", checkLembrar.isChecked)
            if (checkLembrar.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else {
                Prefs.setString("lebrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            if (valorUsuario.equals("aluno") && valorSenha.equals("impacta")) {
                var intent = Intent(this, Activity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()


            }
        }

    }
}
