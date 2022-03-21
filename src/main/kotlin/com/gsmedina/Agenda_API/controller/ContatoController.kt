package com.gsmedina.Agenda_API.controller

import com.gsmedina.Agenda_API.dto.ContatoDto
import com.gsmedina.Agenda_API.model.Contato
import com.gsmedina.Agenda_API.reponse.Response
import com.gsmedina.Agenda_API.repository.ContatoRepository
import com.gsmedina.Agenda_API.service.ContatoService
import com.gsmedina.Agenda_API.view.ContatoView
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contato")
class ContatoController(val contatoService: ContatoService) {

    @GetMapping
    fun mostrarTodos(): List<Contato>{
        return contatoService.listarTodos()
    }

    @GetMapping("/{id}")
    fun mostrar(@PathVariable id:Long): Contato?{
        return  contatoService.listaPorID(id)
    }

    @GetMapping("/nome/{nome}")
    fun mostrarPorNome(@PathVariable nome: String): List<Contato>?{
        return contatoService.listaPorNome(nome)
    }

    @GetMapping("/email/{email}")
    fun mostrarPorEmail(@PathVariable email: String): List<Contato>?{
        return contatoService.listaPorEmail(email)
    }

    @PostMapping
    fun adicionar(@RequestBody contatoDto: ContatoDto, result: BindingResult): ResponseEntity<Response<ContatoView>> {
        val response: Response<ContatoView> = Response<ContatoView>()

        if(result.hasErrors()) {
            result.allErrors.forEach { erro -> erro.defaultMessage?.let { response.erros.add(it) } }
            return ResponseEntity.badRequest().body(response)
        }

        val contato: Contato = contatoService.salvar(contatoDto)
        val contatoView: ContatoView = ContatoView(contato.nome, contato.numero, contato.email, contato.id)
        response.data = contatoView
        return ResponseEntity.ok(response)

    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){
        contatoService.deletar(id)

    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody contatoDto: ContatoDto){
        
    }
}