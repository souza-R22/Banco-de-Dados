CREATE DATABASE crud_produtos;

USE crud_produtos;

CREATE TABLE produtos (

    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT NOT NULL,
    categoria VARCHAR(50) NOT NULL

);

SELECT * FROM produtos;