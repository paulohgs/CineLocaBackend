# Cineloca - Sistema de Aluguel de DVDs

## Descrição

Cineloca é um sistema de aluguel de DVDs desenvolvido em Java usando Spring Boot para o backend e Angular para o frontend. O sistema permite que os usuários criem contas, visualizem DVDs disponíveis para aluguel e realizem transações de aluguel. O projeto também inclui uma área administrativa para gerenciamento de usuários e DVDs.

## Tecnologias Utilizadas

- **Backend**: Spring Boot, Spring Data JPA, PostgreSQL
- **Frontend**: Angular
- **Banco de Dados**: PostgreSQL
- **Outras Tecnologias**: Docker, JPA, REST API

## Funcionalidades

### Usuários

- **Cadastro de Usuário**: Usuários podem se cadastrar no sistema.
- **Login**: Usuários podem realizar login em suas contas.
- **Gerenciamento de Conta**: Usuários podem atualizar suas informações e visualizar o histórico de aluguéis.

### Administrador

- **Gerenciamento de DVDs**: Administradores podem adicionar, editar ou remover DVDs do catálogo.
- **Gerenciamento de Usuários**: Administradores podem visualizar e gerenciar contas de usuários.

### Aluguel de DVDs

- **Busca de DVDs**: Usuários podem buscar DVDs por título, gênero ou ano.
- **Aluguel**: Usuários podem alugar DVDs disponíveis.

## Pré-requisitos

Antes de começar, verifique se você tem os seguintes requisitos instalados:

- Java JDK 11 ou superior
- PostgreSQL
- Node.js e npm (para o frontend Angular)
- Docker (opcional)

## Instalação

### Backend

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu_usuario/cineloca-backend.git
   cd cineloca-backend
   ```
2. Configure o banco de dados PostgreSQL:
   - Crie um banco de dados chamado cineloca_db.
   - Atualize as credenciais no arquivo src/main/resources/application.properties. 
3. Execute o projeto Spring Boot:
   ```bash
   ./mvnw spring-boot:run
   ```
### Frontend

1. Clone o repositório do frontend:
   ```bash
   git clone https://github.com/seu_usuario/cineloca-frontend.git
   cd cineloca-frontend
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

3. Inicie o servidor Angular:
   ```bash
   ng serve
   ```

## Uso

1. Acesse o frontend no navegador em `http://localhost:4200`.
2. Crie uma conta ou faça login com uma conta existente.
3. Navegue pelo catálogo de DVDs e alugue os que desejar.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

