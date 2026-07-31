# Agência de Turismo em JPA

Projeto que atende ao pedido do trabalho: implementa uma classe persistente
(`Cliente`) que **herda** de `Pessoa`, salva no banco de dados via **JPA/Hibernate**,
e permite **pesquisar pelo CPF**.

## Estrutura

```
src/main/java/com/agencia/
├── model/
│   ├── Pessoa.java      -> classe base (@MappedSuperclass): id, nome, cpf, telefone
│   └── Cliente.java     -> entidade (@Entity) que herda de Pessoa, com email e destino
├── dao/
│   ├── JPAUtil.java     -> cria o EntityManager (conexão com o banco)
│   └── ClienteDAO.java  -> salvar(cliente) e buscarPorCpf(cpf)
└── Main.java            -> menu de console para testar
```

## Como funciona a herança

`Pessoa` é anotada com `@MappedSuperclass`, ou seja, ela não vira uma tabela
própria — seus campos (`id`, `nome`, `cpf`, `telefone`) são incorporados na
tabela de quem herda dela. `Cliente` estende `Pessoa` e é a entidade real,
persistida na tabela `cliente`. Isso significa que, se o grupo quiser criar
depois `Funcionario extends Pessoa` ou `Professor extends Pessoa`, basta repetir
o mesmo padrão.

## Banco de dados

Usa **H2** (banco de dados leve, em arquivo, sem precisar instalar servidor).
O arquivo do banco é criado automaticamente em `./data/agencia_db`.
Se preferir usar MySQL/PostgreSQL, basta trocar as propriedades em
`src/main/resources/META-INF/persistence.xml`.

## Como rodar

Pré-requisitos: Java 17+ e Maven instalados.

```bash
mvn compile exec:java
```

Isso abre um menu no console:

```
===== AGÊNCIA DE TURISMO =====
1 - Cadastrar cliente
2 - Buscar cliente por CPF
0 - Sair
```

1. Escolha `1` para cadastrar um cliente (nome, CPF, telefone, email, destino).
2. Escolha `2` e informe o CPF para pesquisar o cliente salvo.

## Se quiser importar no Eclipse/IntelliJ

Basta importar como "projeto Maven existente"  o `pom.xml` já traz as
dependências do Hibernate (implementação da JPA) e do H2.
