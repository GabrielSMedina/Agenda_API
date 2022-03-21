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

    fun salvar(contatoDto: ContatoDto): Contato{
        val contato: Contato = Contato(contatoDto.nome, contatoDto.numero, contatoDto.email)
        return contatoRepository.save(contato)
    }
}