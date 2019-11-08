# language: pt

Funcionalidade: Um usuário deve conseguir visualizar os tópicos cadastrados
	Eu, enquanto usuário
	Devo conseguir visualizar os tópicos registrados
	De forma a poder discutir assuntos de meu interesse com os membros da comunidade

  Cenário: Consigo acessar a lista de tópicos
  	Quando eu acesso a página "Tópicos"
  	Então eu devo conseguir ver a lista de tópicos cadastrados
  	
  Cenário: Consigo visualizar tópicos cadastrados
  	Dado que há tópicos cadastrados
  	Quando eu acesso a página "Tópicos"
  	Então eu consigo visualizar estes tópicos 
