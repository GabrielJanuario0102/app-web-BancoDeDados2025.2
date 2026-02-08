CREATE TABLE armazem (
    id_armazem SERIAL PRIMARY KEY,
    estado VARCHAR(80) NOT NULL,
    cidade VARCHAR(80) NOT NULL,
    numero VARCHAR(10) NOT NULL
);

CREATE TABLE loja (
    id_loja SERIAL PRIMARY KEY,
    matriz BOOLEAN NOT NULL DEFAULT FALSE,
    estado VARCHAR(80) NOT NULL,
    cidade VARCHAR(80) NOT NULL,
    numero VARCHAR(10) NOT NULL
);

CREATE TABLE fornecedor (
    id_fornecedor SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE ingrediente (
    id_ingrediente SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    tipo_medida VARCHAR(20) NOT NULL
);

CREATE TABLE receita (
    id_receita SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE TABLE empregado (
    id_empregado SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    telefone VARCHAR(80) NOT NULL,
    estado VARCHAR(80) NOT NULL,
    cidade VARCHAR(80) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    id_loja INTEGER NOT NULL,

    FOREIGN KEY (id_loja)
        REFERENCES loja (id_loja)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE estoque (
    id_armazem INTEGER NOT NULL,
    id_ingrediente INTEGER NOT NULL,
    quantidade_armazenada INTEGER NOT NULL,

    PRIMARY KEY (id_armazem, id_ingrediente),

    FOREIGN KEY (id_armazem)
        REFERENCES armazem (id_armazem)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY (id_ingrediente)
        REFERENCES ingrediente (id_ingrediente)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE fornecedor_ingrediente (
    quantidade_fornecida INTEGER NOT NULL,
    id_fornecedor INTEGER NOT NULL,
    id_ingrediente INTEGER NOT NULL,

    PRIMARY KEY (id_fornecedor, id_ingrediente),

    FOREIGN KEY (id_fornecedor)
        REFERENCES fornecedor (id_fornecedor)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY (id_ingrediente)
        REFERENCES ingrediente (id_ingrediente)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE abastecimento_loja (
    id_abastecimento SERIAL PRIMARY KEY,
    data_abastecimento DATE NOT NULL,
    quantidade_ingrediente INTEGER NOT NULL,
    id_armazem INTEGER NOT NULL,
    id_loja INTEGER NOT NULL,
    id_ingrediente INTEGER NOT NULL,

    FOREIGN KEY (id_armazem)
        REFERENCES armazem (id_armazem)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    FOREIGN KEY (id_loja)
        REFERENCES loja (id_loja)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    FOREIGN KEY (id_ingrediente)
        REFERENCES ingrediente (id_ingrediente)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE ingrediente_receita (
    quantidade_ingrediente_na_receita DOUBLE PRECISION NOT NULL,
    id_receita INTEGER NOT NULL,
    id_ingrediente INTEGER NOT NULL,

    PRIMARY KEY (id_receita, id_ingrediente),

    FOREIGN KEY (id_receita)
        REFERENCES receita (id_receita)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY (id_ingrediente)
        REFERENCES ingrediente (id_ingrediente)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


CREATE TABLE producao (
    id_producao SERIAL PRIMARY KEY,
    data_producao DATE NOT NULL,
    quantidade_produzida INTEGER NOT NULL,
    id_loja INTEGER NOT NULL,
    id_receita INTEGER NOT NULL,

    FOREIGN KEY (id_loja)
        REFERENCES loja (id_loja)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    FOREIGN KEY (id_receita)
        REFERENCES receita (id_receita)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);