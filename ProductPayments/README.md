## API REST - Gerenciamento de Pagamentos de Produtos
A API desenvolvida disponibiliza de alguns métodos que podem ser consumidos para executar diversas requisições (CRUD).

## Tecnologias utilizadas
* Eclipse versão 2020-12 (4.18.0)
* Java versão 15.0
* Spring Boot versão 4.10.0
* Lombok versão 1.18.18
* DBeaver versão 7.3.4.202101311042
* Postman versão 8.0.7
* Git versão 2.29.2.windows.3

## Serviços utilizados
* Banco de Dados PostGreSQL
* Swagger versão 2.9.2
* GitHub

## Funcionalidades
- Cadastrar categorias dos produtos
- Cadastrar produtos, consultar os produtos em ordem alfabética, por padrão são exibidos 12 produtos, mas é possível inserir um total limitado a 30, buscar o produto através do Id, atualizar algum dado do produto, buscar os produtos pela categoria, listar os produtos em ordem decrescente e crescente do preço, e deletar um produto
- Cadastrar clientes, consultar clientes ordenado pelo e-mail, atualizar algum dado do cliente
- Cadastrar status dos pedidos
- Gerar um pedido através de uma compra de produtos, consultar os pedidos através do Id do cliente, buscar os pedidos que estão com o status de “Aguardando”, e alterar para o status do pagamento para “Aprovado”, “Reprovado” ou “Aguardando”

## Diagrama de Entidade e Relacionamento 
![ERD](https://user-images.githubusercontent.com/22798725/111677152-b484a680-87fd-11eb-8ddb-d3fa0ff666be.png)

## Versão API
1.0

## Autores
* **DIEGO CEZARINO**: @Dcezarino(https://github.com/Dcezarino)