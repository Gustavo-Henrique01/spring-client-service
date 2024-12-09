Descrição do Repositório: Projeto Spring Cliente
Este repositório contém a implementação de um conjunto de projetos Spring Boot para a disciplina de LP4, organizados em três etapas. O objetivo é criar aplicações backend para consulta de informações de clientes, retornando os dados em formato JSON, utilizando métodos REST com a requisição HTTP GET. Cada etapa possui objetivos específicos, detalhados a seguir:

Etapa 1 - Projeto Spring Cliente
Objetivo: Consultar o nome do cliente com base no código fornecido como parâmetro, retornando o código e nome em formato JSON.

Configurações:
Porta do servidor: 8081.
Classe principal: Trabalho2Application.
Implementações principais:
Classe Cliente com atributos id, nome .
Controlador com método buscarCliente.
Teste da aplicação: Utilizar o Postman para enviar requisições GET para a URL:
http://localhost:8081/clientes/1.

Etapa 2 - Projeto Spring CPF
Objetivo: Consultar o CPF do cliente com base no código fornecido, retornando o código, nome e CPF em formato JSON.
Configurações:
Porta do servidor: 8082.
Classe principal: Trabalho2Application.
Implementações principais:
Classe CPF com atributos id, nome e cpf.
Controlador com método buscarClienteCPF.
Teste da aplicação: Utilizar o Postman para enviar requisições GET para a URL:
http://localhost:8082/cpf/1.

Etapa 3 - Projeto Serviço ClienteCPF
Objetivo: Consultar o nome e CPF do cliente com base no código fornecido, utilizando um serviço com WebClient para acessar outros endpoints e consolidar os dados. Retornar o código, nome e CPF em formato JSON.
Configurações:
Porta do servidor: 8083.
Classe principal: Trabalho2Application.
Implementações principais:
Classe ClienteCPF com atributos id, nome e cpf.
Controlador com método buscarClienteComCPF, que consome o serviço implementado na camada Service.
Teste da aplicação: Utilizar o Postman para enviar requisições GET para a URL:
http://localhost:8083/cliente/1/cpf.

