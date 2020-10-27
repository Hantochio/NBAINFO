package br.com.higorpimentel.nbainfo

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.net.URL

object JogadoresService {

    val host = "https://higao1409.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getJogadores() : List<Jogadores> {

        val url = "$host/jogadores"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)

       return parserJson<List<Jogadores>>(json)

    //    return DatabaseManager.getJogadoresDAO().findAll()





    }

    fun saveJogadores(jogadores: Jogadores){
        val json = GsonBuilder().create().toJson(jogadores)
       HttpHelper.post("$host/jogadores", json)

     //   DatabaseManager.getJogadoresDAO().insert(jogadores)


    }

    fun saveOffline (jogadores: Jogadores) : Boolean {
        val dao = DatabaseManager.getJogadoresDAO()

        if (! existeJogadores(jogadores)){
            dao.insert(jogadores)
        }
        return true
    }

    fun existeJogadores (jogadores: Jogadores): Boolean {
        val dao = DatabaseManager.getJogadoresDAO()
        return dao.getById(jogadores.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}