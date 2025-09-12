# 📦 Delivery Tech API

Sistema de delivery moderno desenvolvido com Spring Boot 3.2.x e Java 21, utilizando as mais recentes funcionalidades da linguagem.

## 📋 Sobre o Projeto - GCP

Este projeto foi desenvolvido como parte da disciplina **Arquitetura de Sistemas** e representa a base de um sistema de delivery completo. A aplicação demonstra o uso de tecnologias modernas e boas práticas de desenvolvimento.

## 🛠️ Tecnologias Utilizadas

### Core
- **Java 21 LTS** - Versão mais recente com recursos modernos
- **Spring Boot 3.2.x** - Framework principal
- **Maven** - Gerenciamento de dependências

### Dependências
- **Spring Web** - APIs REST
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco em memória para desenvolvimento
- **Spring Boot DevTools** - Ferramentas de desenvolvimento
- **Lombok** - Anotações

- ## 📄 Documentação da API

Acesse via Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## ⚙️ Como Rodar o Projeto

### 🔧 Pré-requisitos

- Java 21
- Maven
- Docker e Docker Compose (opcional)

### 🖥️ Via Maven

```bash
git clone https://github.com/seuusuario/delivery-api.git
cd delivery-api
./mvnw spring-boot:run
```

### 🐳 Via Docker

```bash
docker-compose up --build
```
