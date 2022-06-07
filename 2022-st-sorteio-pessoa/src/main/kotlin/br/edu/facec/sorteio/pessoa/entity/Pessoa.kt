package br.edu.facec.sorteio.pessoa.entity

import br.edu.facec.infra.NoArg
import java.time.LocalDate
import java.util.UUID

@NoArg
class Pessoa constructor(
    var id: UUID = UUID.randomUUID(),
    var nome: String,
    var telefone: String,
    var email: String
) {

    var cpf: String? = null
    var nascimento: LocalDate? = LocalDate.of(2002,9,16)
    var endereco: String? = null

    init {
        if (nome.isBlank()) {
            throw IllegalArgumentException("Nome da pessoa deve ser informado.")
        }
        if (telefone.isBlank()) {
            throw IllegalArgumentException("Telefone da pessoa deve ser informado.")
        }
        if (email.isBlank()) {
            throw IllegalArgumentException("E-mail da pessoa deve ser informado.")
        }
    }

    fun hasId(id: UUID): Boolean {
        return this.id == id
    }

    fun hasNascimentoLessThan(data: LocalDate): Boolean {
        return nascimento == null || nascimento!!.isBefore(data)
    }

}