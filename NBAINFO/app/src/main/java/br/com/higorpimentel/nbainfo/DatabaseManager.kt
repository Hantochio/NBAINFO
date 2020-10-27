package br.com.higorpimentel.nbainfo

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: LMSDatabase

    init {
        val contexto = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            contexto,
            LMSDatabase::class.java,
            "lms.sqlite"

        ).build()
    }

    fun getJogadoresDAO(): JogadoresDAO {
        return dbInstance.jogadoresDAO()
    }

}