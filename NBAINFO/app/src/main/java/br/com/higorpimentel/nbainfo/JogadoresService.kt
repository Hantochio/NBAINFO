package br.com.higorpimentel.nbainfo

object JogadoresService {
    fun getJogadores() : List<Jogadores> {
        val jogadores = mutableListOf<Jogadores>()

        for (i in 1..10) {
            val j = Jogadores()
            j.nome = "Jogador $i"
            j.ementa = "Ementa $i"

            jogadores.add(j)
        }

        return jogadores
    }

}