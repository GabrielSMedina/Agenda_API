package com.gsmedina.Agenda_API.repository

import com.gsmedina.Agenda_API.model.Contato
import org.springframework.data.jpa.repository.JpaRepository

interface ContatoRepository: JpaRepository<Contato, Long> {

}