CREATE TABLE tb_seller(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
cpf VARCHAR(12) NOT NULL,
phonenumber VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
logradouro VARCHAR(255) NOT NULL,
complemento VARCHAR(255)  NULL,
bairro VARCHAR(255) NOT NULL,
localidade VARCHAR(255) NOT NULL,
uf VARCHAR(255)NOT NULL);