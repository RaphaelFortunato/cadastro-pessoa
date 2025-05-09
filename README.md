# 👇 Cadastro de Pessoa - CRUD 👇

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot** e **Thymeleaf** . A aplicação é focada na gestão de pessoas, com funcionalidades de CRUD. Utiliza o banco de dados **PostgreSQL** para persistência de dados e **Spring Data JPA** para o gerenciamento da camada de dados. Para o front-end foi utilizado o Thymeleaf para uma melhor interação com o back-end.

## :ledger: Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
-  **Thymeleaf**
- **PostgreSQL** (persistência de dados)
- **Spring Data JPA** (interação com o banco de dados)
- **Maven** (para gerenciamento de dependências)


## :ledger: Funcionalidades

- **CRUD de Pessoas**: Criação, leitura, atualização e exclusão de produtos na aplicação.
- **Persistência com PostgreSQL**: Armazenamento de dados no banco de dados PostgreSQL utilizando **Spring Data JPA**.
- **Tratamento de Exceções**: Exceções personalizadas e globais para um melhor controle de erros e respostas para o cliente.
  
## :ledger: Estrutura do Projeto

O projeto segue a seguinte estrutura básica:

```
src/main/java/com/fortunadev/enity_crud
  ├── controller      # Contém os controladores da API
  ├── model           # Modelos de dados
  ├── repository      # Repositório para acessar o banco de dados
  ├── service         # Lógica de negócios
  ├── exception       # Tratamento de exceções globais

src/main/resources/static/bootstrap-5.1.3-dist/css
  ├── bootstrap.min.css      # Página de estilo

src/main/resources/static/bootstrap-5.1.3-dist/js
  ├── bootstrap.min.js      # Página de javascript

src/main/resources/static/jquery-3.6.1-dist
  ├── jquery-3.6.1-dist.min.js      # JQuery

src/main/resources/templates
  ├── editar-pessoa.html      # Página para edição
  ├── lista-pessoas.html      # Página que lista todas as pessoas cadastras e realiza a busca por nome
  ├── novo-cadastro.html      # Página para realizar o cadastramento
  
```

##  :ledger: Como Rodar o Projeto

### Pré-requisitos

- **Java 21** instalado
- **Maven** instalado
- **PostgreSQL** configurado localmente ou remotamente
- **Thymeleaf**

### Passos para rodar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/ViniciusBorgesdeAraujo/springboot-course-project.git](https://github.com/RaphaelFortunato/cadastro-pessoa.git)
   ```

2. Entre na pasta do projeto:
   ```bash
   cd enity-crud
   ```

3. Configure o banco de dados PostgreSQL. Adicione as credenciais de conexão no arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Execute o projeto:
   ```bash
   ./mvnw enity-crud:run
   ```


5. A aplicação estará disponível na URL: `http://localhost:8080`

## :ledger: Endpoints

A API possui os seguintes endpoints:

- **GET** `/` - Listar pessoas cadastradas
- **POST** `/salvar` - Cadastrar nova pessoa
- **GET** `/deletar/{id}` - Excluir pessoa
- **PUT** `/editar/{id}` - Editar pessoa
- **GET** `/buscar` - Pesquisa pelo nome da pessoa
