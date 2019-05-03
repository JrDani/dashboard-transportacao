# API SPRING BOOT

Criado para alimentar um dashboard que relaciona veículos de transporte, carga, produtos (minério) e clientes.

  - Api Restful
  - Mysql e Hibernate
  - Criação do banco automaticamente: Flyway Migrator e Seeder
  - Validação com Hibernate, HandlerException e ValidationMessages.properties

# Usar

  - Abra o arquivo src/main/resources/application.properties para mudar a senha e o usuário do banco de dados
  - Só executar o Spring Boot. Programado para rodar na porta 8090
  - Banco de dados e tabelas serão criadas automaticamente

Veja também, o Client:
  - Neste repositório, na pasta client, há um SPA criado em Angular JS

### Rotas

Todas as rotas abaixo possuem os verbos: GET, PUT e POST configurados

| Recurso | Endereço | Parâmetros |
| ------ | ------ | ------ |
| Cliente | http://localhost:8090/clientes | /ID |
| Minério | http://localhost:8090/minerios | /ID |
| Pedido | http://localhost:8090/pedidos | /ID |
| Veiculo | http://localhost:8090/veiculos | /ID |
| Tipo de veículo | http://localhost:8090/tipo-veiculos | /ID |

### Validação 

Criado usando anotações do Hibernate. Caso algum campo sejá inválido, a api retornará um objeto JSON, contendo 2 propriedades: "msg_dev" e "msg_user" .
```sh
{
    "msg_dev": "Field error in object 'minerio' on field 'nome': rejected value [null]; codes [NotNull.minerio.nome,NotNull.nome,NotNull.java.lang.String,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [minerio.nome,nome]; arguments []; default message [nome]]; default message [O campo {0} é obrigatório]",
    "msg_user": "O campo nome é obrigatório"
}
```

Mostre o "msg_user" para o usuário final

### Objetos JSON

Pedido
```sh
{
  "id_pedido": 17,
  "veiculo": {
      "id_veiculo": 19,
      "tipoVeiculo": {
          "id_tipo_veiculo": 4,
          "nome": "Estrada"
      }
  },
  "cliente": {
      "id_cliente": 3,
      "nome": "Pedreira Guaravera"
  },
  "minerio": {
      "id_minerio": 10,
      "nome": "Cátodo de cobre grado A",
      "valor_grama": 785.135211
  },
  "destino": "SP/SP 101",
  "quantidade_kg": 51,
  "data_pedido": 1556806895000,
  "total": 40041895.761
}
```

Cliente
```sh
{
  "id_cliente": 1,
  "nome": "Daniel Junior"
}
```

Minério
```sh
{
  "id_minerio": 1,
  "nome": "Ouro",
  "valor_grama": 162.27082
}
```

Tipo de veículo
```sh
{
  "id_tipo_veiculo": 1,
  "nome": "Ferrovia"
}
```

Veículo
```sh
{
  "id_veiculo": 1,
  "tipoVeiculo": {
      "id_tipo_veiculo": 1,
      "nome": "Ferrovia"
  }
}
```

License
----
MIT
