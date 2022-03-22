package com.gsmedina.Agenda_API.service

import com.gsmedina.Agenda_API.dto.ContatoDto
import com.gsmedina.Agenda_API.model.Contato
import com.gsmedina.Agenda_API.repository.ContatoRepository
import org.springframework.stereotype.Service

@Service
class ContatoService(val contatoRepository: ContatoRepository) {

    fun listarTodos(): List<Contato>{
        return contatoRepository.findAll()
    }

    fun listaPorNome(nome: String): List<Contato>?{
        return contatoRepository.findBynome(nome)
    }

    fun listaPorEmail(email: String): List<Contato>?{
        return contatoRepository.findByemail(email)
    }

    fun listaPorID(id: Long): Contato?{
        return contatoRepository.findByid(id)
    }

    fun salvar(contatoDto: ContatoDto): Contato{
        val contato: Contato = Contato(contatoDto.nome, contatoDto.numero, contatoDto.email)
        return contatoRepository.save(contato)
    }

    fun deletar(id: Long){
        contatoRepository.deleteById(id)
    }

    fun atualizar(contato: Contato){
        contatoRepository.save(contato)
    }
}