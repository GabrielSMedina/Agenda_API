# Agenda_API

Uma API Web, tentando seguir o padrão REST desenvolvida em kotlin e que tem como objetivo fazer a persistência dos dados de contatos de uma agenda telefônica em um banco de dados.

## Stack
- Koltin
- Spring boot
- Gradle
- Flyway
- postgreSQL

## Como usar
Para o uso desta API é necessário que se tenha o postgreSQL 14 instalado na maquina, além do Java. Tendo instalado estes itens você deve abrir o arquivo "application.properties" no caminho "Agenda_API/src/main/resources/" e trocar os dados pelos de sua database. Agora basta executar o arquivo "AgendaApiApplication.kt" e fazer o uso desejado desta API.

## Considerações
Este foi um projeto feito em apenas um dia, com o intuito de treinar a criação de APIs em koltin. O código esta funcional, porem ainda estão ausentes algumas partes relevantes como:
- Testes unitários e integrados
- Inserção de validações pela spring boot validation
- Melhor tratamento dos dados pelas DTOs
- Polimento da classe View
