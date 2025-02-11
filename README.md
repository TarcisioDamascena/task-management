# Task Management 

Este repositório contém a API desenvolvida com Java Spring para uma aplicação full stack. O backend está configurado para rodar junto com um banco de dados PostgreSQL dentro do Docker. Além disso, a API está documentada utilizando Swagger.

## Tecnologias Utilizadas

### Backend:
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Jwt
- PostgreSQL
- Flyway (para migração do banco de dados)
- Docker
- Swagger (para documentação da API)

### Frontend:
O frontend foi desenvolvido utilizando Angular e está disponível em outro repositório no GitHub:
[Link para o repositório do frontend](https://github.com/TarcisioDamascena/angular-task-management-app)

## Como Executar o Projeto

### Requisitos
- Docker
- JDK 21

### Passos para Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/TarcisioDamascena/task-management.git
   cd task-management
   ```

2. Execute a aplicação com Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. A API estará disponível em:
   ```
   http://localhost:8080
   ```

4. A documentação do Swagger pode ser acessada em:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Endpoints da API

![image](https://github.com/user-attachments/assets/24757422-99f7-44b0-901c-5c43180e0d6c)

Para mais detalhes sobre os endpoints, acesse a documentação gerada pelo Swagger no link mencionado acima.
