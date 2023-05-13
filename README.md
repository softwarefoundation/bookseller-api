# bookseller-api
Book Seller API



## Banco de dados
A aplicação utiliza o banco de dados H2 e como é um banco em memória ele é recriado a cada execução da aplicação.

### Acesso
O banco de dados pode ser acesso pelo console WEB, que fica disponível na mesma url da aplicação + /h2-console/ Exe: http://localhost:8080/h2-console/

Configuração do console WEB: Para fazer login no console web utilize as configurações abaixo:
* JDBC URL: jdbc:h2:mem:bookseller
* User Name:admin
* Password:admin

Essas informações podem ser encontraradas no arquivoapplication.properties
