# language: pt

Funcionalidade: Um usuario deve conseguir visualizar os tópicos cadastrados
	Eu, enquanto usuario
	Devo conseguir visualizar os topicos registrados
	De forma a poder discutir assuntos de meu interesse com os membros da comunidade

	Cenário: Consigo visualizar topicos cadastrados
  	Dado que ha topicos cadastrados
  	Quando eu acesso a pagina "Topicos"
  	Então eu consigo visualizar estes topicos
	
  Cenário: Consigo acessar a lista de topicos
  	Quando eu acesso a pagina "Topicos"
  	Então eu devo conseguir ver a lista de topicos cadastrados
  	
  @wip
  Cenário: Consigo acessar a pagina de cadastro de topicos
  	Quando eu acesso a pagina "Topicos"
  	E clico em "Novo Tópico"
  	Então eu devo ser redirecionado para a página "Novo Tópico"
  	
  
  	