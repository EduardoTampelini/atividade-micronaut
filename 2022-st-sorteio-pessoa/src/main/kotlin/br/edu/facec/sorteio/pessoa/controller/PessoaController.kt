package br.edu.facec.sorteio.pessoa.controller

import br.edu.facec.sorteio.pessoa.entity.Pessoa
import br.edu.facec.sorteio.pessoa.service.PessoaService
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import java.util.*

@Controller("/pessoas")
class PessoaController(@Inject private val pessoaService: PessoaService) {

    @Post
    fun save(@Body pessoa: Pessoa): UUID {
        return pessoaService.save(pessoa);
    }

    @Get("/{id}")
    fun findById(@PathVariable("id") id: UUID): Pessoa? {
        return pessoaService.findById(id)
    }

    @Get
    fun findAll(): List<Pessoa> {
        return pessoaService.findAll()
    }
    @Delete("/{id}")
    fun deleteById(@PathVariable("id") id: UUID) {
        return pessoaService.deleteById(id)
    }
    @Put("/{id}")
    fun updateById(@PathVariable("id") id: UUID, @Body pessoa: Pessoa){
      return pessoaService.updateById(id , pessoa)
    }
}