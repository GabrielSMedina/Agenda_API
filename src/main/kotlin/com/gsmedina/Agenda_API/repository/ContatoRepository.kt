package com.gsmedina.Agenda_API.repository

import com.gsmedina.Agenda_API.model.Contato
import org.springframework.data.jpa.repository.JpaRepository

interface ContatoRepository: JpaRepository<Contato, Long> {
    fun findByid(id: Long):Contato?

    fun findBynome(nome: String): List<Contato>?

    fun findByemail(email: String): List<Contato>?
}