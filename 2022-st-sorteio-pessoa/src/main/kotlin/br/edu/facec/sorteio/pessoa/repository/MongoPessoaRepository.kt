package br.edu.facec.sorteio.pessoa.repository

import br.edu.facec.sorteio.pessoa.entity.Pessoa
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import java.util.*

class MongoPessoaRepository(private val mongoClient: MongoClient): PessoaRepository {

    private val pessoaCollecion: MongoCollection<Pessoa> = mongoClient.getDatabase("Sis-Sorteio").getCollection("pessoa", Pessoa::class.java)

    override fun save(pessoa: Pessoa) {
      pessoaCollecion.insertOne(pessoa)
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Pessoa? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Pessoa> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun updateById(id: UUID, pessoa: Pessoa) {
        TODO("Not yet implemented")
    }
}