package br.edu.facec.sorteio.pessoa.repository

import br.edu.facec.sorteio.pessoa.entity.Pessoa
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import java.util.*

class MongoPessoaRepository(private val mongoClient: MongoClient): PessoaRepository {

    private val pessoaCollecion: MongoCollection<Pessoa> = mongoClient.getDatabase("Sis-Sorteio").getCollection("pessoa", Pessoa::class.java)

    override fun save(pessoa: Pessoa) {
      pessoaCollecion.insertOne(pessoa)
    }

    override fun existsById(id: UUID): Boolean {
        return pessoaCollecion.countDocuments(Filters.eq("_id", id)) > 0

    }

    override fun findById(id: UUID): Pessoa? {
        return pessoaCollecion.find(Filters.eq("_id", id)).first()

    }

    override fun findAll(): List<Pessoa> {
        return pessoaCollecion.find().toList()
    }

    override fun deleteById(id: UUID) {
        pessoaCollecion.deleteOne(Filters.eq("_id", id))
    }

    override fun updateById(id: UUID, pessoa: Pessoa) {
        pessoaCollecion.replaceOne(Filters.eq("_id", id), pessoa)
    }
}