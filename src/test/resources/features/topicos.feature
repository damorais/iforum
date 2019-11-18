# language: pt

Funcionalidade: Um usuário deve conseguir visualizar os tópicos cadastrados
	Eu, enquanto usuário
	Devo conseguir visualizar os tópicos registrados
	De forma a poder discutir assuntos de meu interesse com os membros da comunidade

	Cenário: Consigo visualizar tópicos cadastrados
  	Dado que ha tópicos cadastrados
  	Quando eu acesso a página "Tópicos"
  	Então eu consigo visualizar estes tópicos
	
  Cenário: Consigo acessar a lista de topicos
  	Quando eu acesso a página "Tópicos"
  	Então eu devo conseguir ver a lista de tópicos cadastrados
  
  Cenário: Consigo acessar a pagina de cadastro de topicos
  	Quando eu acesso a página "Tópicos"
  	E clico no link "Novo Tópico"
  	Então eu devo ser redirecionado para a página "Novo Tópico"
  	
  @wip		
  Cenário: Consigo cadastrar um novo tópico
  	Dado que eu estou na página "Novo Tópico"
  	Quando eu preencho o formulário com o título "Exemplo de Tópico" e descrição "Isto é um teste"
  	E clico em "Salvar"
  	Então eu devo ser redirecionado para a página "Tópicos"
  	E uma mensagem de sucesso dizendo "Tópico criado"
  	E um tópico com o título "Exemplo de Tópico" deve estar visível na lista de tópicos 	
  	