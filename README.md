# CafeDaManha_WL
Teste Café da Manhã  WL (API REST). 
Essa aplicação gera uma lista de café da manhã onde os colaboradores de uma empresa podem informar quais comidas irão levar para a comemoração.
a aplicação conta com 4 telas, onde cada uma é responsavel por um processo do CRUD, nesse projeto foram feitas algumas Querys nativas para a criação do CRUD,
algumas regras forma adicionadas, fazendo assim com que não exista a repetição de registros ou registros incompletos, a parte de Front-end foi toda desenvolvida em 
HTML:5,CSS:3 e JavaScript o Back-End foi desenvolvido em JAVA, utilizando o FrameWork Spring, Maven e Insomnia para a realização de testes que requisição, para 
a utilização local foi utilizado a aplicação XAMPP.

## Aplicação café da manhã

### Projeto tipo:
Maven
### Linguagens:
Java
JavaScript
### Front-End
HTML:5
CSS:3
### Java Version:
17
### SpringBoot Version:
3.1.1
### Dependencias:
Spring WEB
Spring Data JPA
MySQL Driver
Lombok
### Aplicação de Testes
insomnia
### Servidor Local
XAMPP 3.3.0

## Requisições de testes utilizadas no Insominia 

Deletar Registro (Metodo Delete): http://localhost:8080/Deletar/11   <-- Informar o ID do registro do banco para a exclusão

Consulta de registro por ID (Metodo GET): http://localhost:8080/RecuperaRegistro/1   <-- Informar o ID do registro do banco para a pesquisa

Modificar Registro (Metodo PUT): http://localhost:8080/Modifica

Cadastrar um Registro (Metodo POST): http://localhost:8080/Registrar

Obter todos os registros (Metodo GET): http://localhost:8080/ObterRegistros
