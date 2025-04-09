
-- DROP DATABASE  IF EXISTS lojinha;
-- CREATE DATABASE  IF NOT EXISTS lojinha CHARSET utf8;

USE talentos_lojinha;

-- DROP TABLE IF EXISTS categorias;
CREATE TABLE categorias (
  idCategoria 	int NOT NULL AUTO_INCREMENT,
  descricao 	varchar(30),
  PRIMARY KEY  (idCategoria)
);

-- DROP TABLE IF EXISTS institucional;
CREATE TABLE institucional (
  idInstituicao int NOT NULL AUTO_INCREMENT,
  nome 		varchar(50),
  cpf_cnpj 	varchar(14) NOT NULL UNIQUE,
  tipoPessoa 	char(1) DEFAULT 'F' COMMENT '{ ''F'' , ''J'' }',
  endereco 	varchar(50),
  bairro 	varchar(30),
  cidade 	varchar(50),
  uf 		varchar(2),
  cep 		varchar(9),
  telefone 	varchar(15),
  email 	varchar(100) NOT NULL UNIQUE,
  logo 		varchar(255),
  PRIMARY KEY (idInstituicao)
);

-- DROP TABLE IF EXISTS nivelUsuarios;
CREATE TABLE nivelUsuarios (
  idNivelUsuario 	int NOT NULL AUTO_INCREMENT,
  nivel 		varchar(20) COMMENT '{''Cliente '', ''Funcionário'', ''Caixa '', ''Financeiro '', ''Gerente '', ''Diretor'', ''Administrador''}',
  PRIMARY KEY (idNivelUsuario)
);


-- DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  idUsuario 		int 	NOT NULL AUTO_INCREMENT,
  email 		varchar(100) NOT NULL UNIQUE,
  senha 		varchar(64) NOT NULL,
  idNivelUsuario 	int 	NOT NULL DEFAULT '1',
  nome 			varchar(50),
  cpf 			varchar(14) NOT NULL UNIQUE,
  endereco 		varchar(50),
  bairro 		varchar(30),
  cidade 		varchar(50),
  uf 			varchar(2),
  cep 			varchar(9) NOT NULL,
  telefone 		varchar(15),
  foto 			varchar(255),
  ativo 		varchar(1) DEFAULT 'N',
  PRIMARY KEY (idUsuario),
  FOREIGN KEY (idNivelUsuario) REFERENCES nivelUsuarios (idNivelUsuario)
);

-- DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos (
  idPedido 		int NOT NULL AUTO_INCREMENT,
  idUsuario 		int,
  dtPedido 		datetime,
  dtPagamento 		datetime,
  dtNotaFiscal 		datetime,
  notaFiscal 		text,
  dtEnvio 		datetime,
  dtRecebimento 	datetime,
  tipoFrete 		int DEFAULT '0' COMMENT '{ { 0, Retirada }, { 1, PAC }, { 2, SEDEX }, { 3, MOTOBOY }, { 4, TRANSPORTADORA} }',
  rastreioFrete 	varchar(255),
  entregaEndereco 	varchar(50),
  entregaNumero 	varchar(10),
  entregaCompl 		varchar(50),
  entregaBairro 	varchar(30),
  entregaCidade 	varchar(50),
  entregaUF 		varchar(2),
  entregaCEP 		varchar(9),
  entregaTelefone 	varchar(15),
  entregaRefer 		varchar(255),
  valorTotal 		decimal(12,2),
  qtdItems 		int,
  dtDevolucao 		datetime,
  motivoDevolucao 	text,
  PRIMARY KEY (idPedido),
  FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario)
);


-- DROP TABLE IF EXISTS produtos;
CREATE TABLE produtos (
  idProduto 	int NOT NULL AUTO_INCREMENT,
  fabricante 	varchar(100),
  nome 		varchar(100),
  marca 	varchar(100),
  modelo 	varchar(100),
  idCategoria 	int,
  descricao 	text,
  unidadeMedida varchar(15),
  largura 	decimal(10,3) COMMENT '9999999.999',
  altura 	decimal(10,3) COMMENT '9999999.999',
  profundidade 	decimal(10,3) COMMENT '9999999.999',
  peso 		decimal(10,3) COMMENT '9999999.999',
  cor 		varchar(7),
  PRIMARY KEY (idProduto),
  FOREIGN KEY (idCategoria) REFERENCES categorias (idCategoria)
);
-- DROP TABLE IF EXISTS estoque;

CREATE TABLE estoque (
  idEstoque 	int NOT NULL AUTO_INCREMENT,
  idProduto 	int,
  dtEntrada 	date COMMENT 'YYYY/MM/DD',
  quantidade 	int DEFAULT '0',
  dtFabricacao 	date COMMENT 'YYYY/MM/DD',
  dtVencimento 	date COMMENT 'YYYY/MM/DD',
  nfCompra 	text,
  precoCompra 	decimal(15,2),
  icmsCompra 	decimal(15,2),
  precoVenda 	decimal(15,2),
  qtdVendida 	int,
  qtdOcorrencia int,
  ocorrencia 	varchar(1024),
  PRIMARY KEY (idEstoque),
  FOREIGN KEY (idProduto) REFERENCES produtos (idProduto)
);

-- DROP TABLE IF EXISTS itemsPedido;
CREATE TABLE itemsPedido (
  idItemPedido 	int NOT NULL AUTO_INCREMENT,
  idPedido 	int,
  ordem 	int,  
  idEstoque	int,
  qtdItem 	int,
  dtDevolucao 	datetime,
  motivoDevolucao text,
  PRIMARY KEY (idItemPedido),
  FOREIGN KEY (idPedido) REFERENCES pedidos (idPedido),
  FOREIGN KEY (idEstoque) REFERENCES estoque (idEstoque)
);


INSERT INTO nivelUsuarios VALUES (1,'Cliente'),(2,'Funcionário'),(3,'Caixa'),(4,'Financeiro'),(5,'Gerente'),(6,'Diretor'),(7,'Administrador');
INSERT INTO usuarios 	   	VALUES 
(2,'admins@localhost','admn',1,'Administrador','11111111111','',NULL,NULL,NULL,NULL,NULL,NULL,'N'),
(3,'cleber@localhost','12346',1,'Cleber','12345678912','','','','','','','','N'),
(4,'abc@localhost','12346',1,'abc','1234678901','Rua A','B','C','DE','01234987','115555-5555','','N');


