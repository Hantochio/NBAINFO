package br.com.higorpimentel.nbainfo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Jogadores::class), version = 1)
abstract class LMSDatabase : RoomDatabase() {

    abstract fun jogadoresDAO() : JogadoresDAO
}