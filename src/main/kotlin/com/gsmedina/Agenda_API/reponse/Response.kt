package com.gsmedina.Agenda_API.reponse

data class Response<T> (
    val erros: ArrayList<String> = arrayListOf(),
    var data: T? = null
)