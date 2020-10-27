package br.com.higorpimentel.nbainfo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "jogadores")
class Jogadores : Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String{
        return "Jogadores(nome=$nome)"
    }

}