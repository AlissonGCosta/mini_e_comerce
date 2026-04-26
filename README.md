# Mini E-commerce API REST

## Atividade

Crie uma API REST de controle de pedidos usando Spring Boot + MySQL. A ideia e simular um mini e-commerce e praticar CRUD, relacionamento entre entidades, validacao, regras de negocio e persistencia com JPA.

## Objetivo

Voce deve construir uma aplicacao onde:

- um cliente pode ter varios pedidos
- um pedido pode ter varios itens
- cada item aponta para um produto
- o sistema calcula o valor total do pedido
- o estoque do produto e reduzido quando o pedido e criado

## Entidades

Modele pelo menos estas tabelas:

| Entidade | Campos |
| --- | --- |
| Cliente | `id`, `nome`, `email` |
| Produto | `id`, `nome`, `preco`, `estoque` |
| Pedido | `id`, `dataCriacao`, `status`, `cliente`, `total` |
| ItemPedido | `id`, `pedido`, `produto`, `quantidade`, `precoUnitario`, `subtotal` |

## Relacionamentos

- Cliente `1:N` Pedido
- Pedido `1:N` ItemPedido
- Produto `1:N` ItemPedido

## Regras de negocio

- nao permitir criar pedido sem cliente
- nao permitir item com quantidade menor ou igual a zero
- nao permitir pedido com produto sem estoque suficiente
- ao criar pedido, calcular subtotal de cada item e total do pedido
- ao criar pedido, diminuir o estoque dos produtos
- status inicial do pedido: `CRIADO`

## Endpoints minimos

| Metodo | Endpoint |
| --- | --- |
| `POST` | `/clientes` |
| `GET` | `/clientes` |
| `POST` | `/produtos` |
| `GET` | `/produtos` |
| `PUT` | `/produtos/{id}` |
| `POST` | `/pedidos` |
| `GET` | `/pedidos` |
| `GET` | `/pedidos/{id}` |
| `PATCH` | `/pedidos/{id}/status` |

## Tecnologias para praticar

- Spring Web
- Spring Data JPA
- MySQL Driver
- Validation
- Lombok, se quiser
- Flyway como extra

## Requisitos tecnicos

- usar DTOs para entrada e saida
- usar `@Valid`
- tratar excecoes com `@ControllerAdvice`
- nao expor entidades diretamente na API
- usar `BigDecimal` para valores monetarios
- configurar MySQL no `application.yml` ou `application.properties`

## Desafios extras

- paginacao em `GET /produtos`
- filtro por nome do produto
- buscar pedidos por cliente
- cancelar pedido e devolver estoque
- adicionar testes com `MockMvc` ou `JUnit`

## Criterios de avaliacao

- os relacionamentos foram modelados corretamente?
- o banco ficou coerente?
- as regras de negocio estao no service, e nao no controller?
- a API responde com status HTTP corretos?
- o estoque e o total do pedido estao consistentes?

## Stack atual do projeto

Este projeto ja esta configurado com:

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- Validation
- Flyway
- MySQL Connector
- Lombok

## Proximo passo sugerido

Uma implementacao consistente pode seguir esta ordem:

1. modelar entidades e relacionamentos
2. criar DTOs de entrada e saida
3. implementar repositories e services com as regras de negocio
4. expor os controllers com validacao
5. adicionar tratamento global de excecoes
6. configurar banco e migracoes
7. criar testes para os fluxos principais
