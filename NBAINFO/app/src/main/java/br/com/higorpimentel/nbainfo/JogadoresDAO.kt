package br.com.higorpimentel.nbainfo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JogadoresDAO {

    @Query("SELECT * FROM jogadores where id=:id")
    fun getById (id: Long): Jogadores?

    @Query("Select * FROM jogadores")
    fun findAll(): List<Jogadores>

    @Insert
    fun insert(jogadores: Jogadores)

    @Delete
    fun delete (jogadores: Jogadores)

}