CREATE TABLE minerio(
	id_minerio BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome varchar(60) NOT NULL,
	valor_grama DECIMAL(10, 6) NOT NULL
)engine=InnoDB default charset=utf8;

CREATE TABLE tipo_veiculo(
	id_tipo_veiculo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome varchar(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente(
	id_cliente BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE veiculo(
	id_veiculo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_tipo_veiculo BIGINT(20),
	FOREIGN KEY (id_tipo_veiculo) REFERENCES tipo_veiculo(id_tipo_veiculo)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE pedido(
	id_pedido BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_veiculo BIGINT(20) NOT NULL,
	id_cliente BIGINT(20) NOT NULL,
	id_minerio BIGINT(20) NOT NULL,
	destino varchar(150) NOT NULL,
	quantidade_kg decimal(15,2) NOT NULL,
	data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (id_veiculo) REFERENCES veiculo(id_veiculo),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	FOREIGN KEY (id_minerio) REFERENCES minerio(id_minerio)
)ENGINE =InnoDB DEFAULT CHARSET=UTF8