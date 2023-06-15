<h1 align="center">
Indústria Automobilística - Desafio API - GFT
</h1>

<br>

<h2> Descrição do Projeto </h2>

<p>Projeto desenvolvido para aplicação dos conceitos de API durante o programa Starter Woman da 
<strong> <a href="https://www.gft.com/br/pt">GFT Brasil</a></strong> 🧡💛</p>

<p>Aplicação para controle de venda de veículo, estoque de peças e fornecedores para uma indústria automobilística</p>

<h2> 🤝 Desenvolvedoras - Grupo 4 </h2>

🔹Ariana Russo

🔹Isabela lima

🔹Gabriela Domingues


<h2>Funcionalidades</h2>

✅ Cadastrar, editar, listar, buscar pelo id e deletar fornecedores;

✅ Listar todas as peças fornecidas por determinado fornecedor informando seu id;

✅ Cadastrar, editar, listar, buscar pelo id e deletar vendedores;

✅ Cadastrar, editar, listar, buscar pelo id e deletar clientes;

✅ Cadastrar, editar, listar, buscar pelo id e deletar peças;

✅ Cadastrar, editar, listar, buscar pelo id e deletar estoque;

✅ Consultar atraves do id, a quantidade, o custo e o valor total de cada peça do estoque;

✅ Consultar a quantidade, o custo e o valor total do estoque; 

✅ Cadastrar, editar, listar, buscar pelo id e deletar veículo de produção própria e importado;

✅ Cadastrar, editar, buscar pelo id e deletar pedido de venda;

✅ Consultar o custo de produção do veículo;

✅ Consultar o valor de venda do veículo;

✅ Cadastrar, editar, listar e deletar usuários (informando sua permissão de administrador ou vendedor);

✅ Restrição de acesso somente ao administrador do sistema;

✅ Pesquisa do endereço atraves do CEP;


<h2> ⭐️ Tecnologias Utilizadas </h2>

✅ Plataforma: STS - Spring Too Suite;

✅ Dependências: MySql Driver, Spring Web, Spring Boot Dev Tools, Spring Data JPA, Spring Security, Gson;

✅ API via cep

✅ Swagger 

✅ Flyway Migration

✅ Linguagem do Software: Java

✅ JDK 17

✅ Banco de Dados: MySQL Workbench


<h2> 👣 Passo-a-Passo</h2>

1. Abrir o projeto na IDE;

2. Abrir a pasta application.properties e trocar username e password do mysql;

3. Executar o Scrip "desafio-api", para popular banco de dados (arquivo gerado pelo MySQL workbench);

4. Executar o projeto;

5. Clique <strong> <a href="http://localhost:8080/swagger-ui.html"> aqui </a></strong> para ser direcionado ao swagger;

6. Informe seu usuário e senha;

7. No controller de Saler Order você terá acesso ao calculo de preço de fabricação e venda de veículo;

8. No controller de Stock você poderá consutar o custo e o valor total de cada peça do estoque assim como o valor total do estoque;

9. Para acessar Sales Order (pedido de venda) será necessário estar com acesso de Seller (vendedor).


<h2> !! Acesso a aplicação !! </h2>

- biraadmin: 123
- biravend: 123

<h2> 🚀 Melhorias Futuras </h2>

✅ Implementação do pedido de venda de peças;

✅ Implementação de alertas de estoque máximo e mínimo;
