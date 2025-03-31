# Cadastro de Pessoas

# Visão Geral

O projeto tem como objetivo gerenciar o cadastro de pessoas, permitindo operações como inserção, edição, exclusão e listagem de registros. Também inclui funcionalidades como busca de endereço via CEP.

# Decisões Técnicas e Arquiteturais

O projeto foi desenvolvido utilizando a arquitetura MVC (Model-View-Controller), garantindo uma separação clara entre a camada de apresentação, a lógica de negócio e a persistência de dados. A escolha do Java EE com CDI e JSF permite uma integração eficiente entre os componentes da aplicação, facilitando a manutenção e escalabilidade.

A persistência dos dados é feita com JPA e Hibernate, garantindo compatibilidade com diversos bancos de dados relacionais. O uso de Managed Beans e EJBs permite um melhor gerenciamento do ciclo de vida dos objetos, garantindo eficiência e organização no código.

# Justificativa para Uso de Frameworks e Bibliotecas

O projeto faz uso das seguintes tecnologias:
## JSF (JavaServer Faces): 
- Para a construção da interface web de forma dinâmica e estruturada.

## CDI (Contexts and Dependency Injection): 
-Para facilitar a injeção de dependências e melhorar a modularização do código.

## JPA/Hibernate: 
- Para simplificar a persistência de dados e evitar a necessidade de escrever consultas SQL manualmente.

## Lombok: 
- Para reduzir a verbosidade do código, eliminando a necessidade de criar getters, setters e construtores manualmente.

## Dom4j: 
- Para manipulação de XML na busca de endereços via CEP.

Essas tecnologias foram escolhidas para garantir um desenvolvimento mais rápido, organizado e seguindo boas práticas de mercado.

## Banco de Dados (PostgreSQL)
- Utilizei o banco de dados PostgreSQL para garantir a segurança e confiabilidade na persistência de dados.


## Layout web
![Image](https://github.com/user-attachments/assets/8311a5f6-d59f-442f-958a-c696f435bd02) 
![Image](https://github.com/user-attachments/assets/6d0d2d4c-314f-404b-818a-f4972a257dc9)
![Image](https://github.com/user-attachments/assets/368af8d2-2ecc-4336-a760-7a04808e3acb)
![Image](https://github.com/user-attachments/assets/5c06df31-eeda-4ea2-811a-4177b0bcbfb5)


## Video
https://github.com/user-attachments/assets/6a2ab0a1-6697-47fe-b6e0-698db06a8e10

# Como Compilar e Executar o Projeto

## Requisitos

- JDK 11 ou superior

- Apache Maven

- Banco de Dados PostgreSQL ou MySQL

- Servidor de Aplicação (WildFly, Payara, Tomcat, etc.)

# Notas Adicionais

- O projeto pode ser estendido para incluir autenticação e controle de acesso.

- Logs podem ser adicionados para facilitar a depuração e a análise de erros.

- Uma API REST pode ser implementada para permitir integração com outros sistemas.

# Passos para Compilação e Execução

- Clone o repositório:

- git clone https://github.com/diego1medeiros/cadastro-de-pessoas/tree/master

- Navegue até a pasta do projeto:

- cd cadastro-pessoas

- Compile o projeto com Maven:

- mvn clean install

- Configure as credenciais do banco de dados no arquivo src/main/resources/META-INF/persistence.xml.

- Faça o deploy no servidor de aplicação:

- mvn wildfly:deploy

Acesse a aplicação pelo navegador em;

(http://localhost:8080/cadastro-de-pessoas-0.0.1-SNAPSHOT/menuPrincipal.xhtml)

(http://localhost:8080/cadastro-de-pessoas-0.0.1-SNAPSHOT/cadastropessoa.xhtml)).

# Como Executar os Testes

- Para rodar os testes automatizados, utilize o comando:
- mvn test
- Os testes cobrem a lógica de negócio e a persistência dos dados, garantindo o correto funcionamento da aplicação.

# Autor

Diego Medeiros Jesus

https://www.linkedin.com/in/diego-medeiros-jesus-50746717a
