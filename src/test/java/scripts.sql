/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  patri
 * Created: 22 de jun. de 2023
 */

DROP TABLE compraJogo;

DROP TABLE contaSecundariaJogo;
DROP TABLE contaPrincipalJogo;
DROP TABLE contaVinculoJogo;

DROP TABLE usuarioJogo;

CREATE TABLE usuarioJogo (
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(80),
    idade NUMBER,
    dataNascimento VARCHAR(10),
    pais VARCHAR(50),
    email VARCHAR(30),
    CONSTRAINT pk_CPFur PRIMARY KEY (cpf)
);

CREATE TABLE contaVinculoJogo (
    nickName VARCHAR(15) NOT NULL,
    tipoConta VARCHAR(20),
    CONSTRAINT pk_nickNameCon PRIMARY KEY (nickName)
);

CREATE TABLE contaPrincipalJogo (
    nickNamePrincipal VARCHAR(15) NOT NULL,
    cpf VARCHAR(14),
    login VARCHAR(20),
    senha VARCHAR(20),
    perguntaSeguranca VARCHAR(60),
    respostaSeguranca VARCHAR(60),
    CONSTRAINT pk_nickNameCp PRIMARY KEY (nickNamePrincipal),
    CONSTRAINT fk_nickNameCp FOREIGN KEY (nickNamePrincipal) REFERENCES contaVinculoJogo(nickName),
    CONSTRAINT fk_cpfUr FOREIGN KEY (cpf) REFERENCES usuarioJogo(cpf)
);

CREATE TABLE contaSecundariaJogo (
    nickNameSecundaria VARCHAR(15) NOT NULL,
    cpf VARCHAR(14),
    nickNamePrincipal VARCHAR(15),
    login VARCHAR(20),
    senha VARCHAR(20),
    perguntaSeguranca VARCHAR(60),
    respostaSeguranca VARCHAR(60),
    permCardCred NUMBER(1) DEFAULT 0,
    permContImp NUMBER(1) DEFAULT 0,
    CONSTRAINT pk_nickNameCs PRIMARY KEY (nickNameSecundaria),
    CONSTRAINT fk_nickNameCs FOREIGN KEY (nickNameSecundaria) REFERENCES contaVinculoJogo(nickName),
    CONSTRAINT fk_nickNameCp2 FOREIGN KEY (nickNamePrincipal) REFERENCES contaPrincipalJogo(nickNamePrincipal),
    CONSTRAINT fk_cpfUr2 FOREIGN KEY (cpf) REFERENCES usuarioJogo(cpf)
);

CREATE TABLE compraJogo (
   id NUMBER NOT NULL,
   nickName VARCHAR(15),
   dataCompra Date,
   quantTotal NUMBER,
   precoTotal NUMBER,
   CONSTRAINT pk_idCom PRIMARY KEY (id),
   CONSTRAINT fk_nickNameCon FOREIGN KEY (nickName) REFERENCES contaVinculoJogo(nickName)
);

delete from compraJogo;

delete from contaSecundariaJogo;
delete from contaPrincipalJogo;
delete from contaVinculoJogo;

delete from usuarioJogo;