# Portal de Aprovados em Concursos Públicos

Projeto **Full Stack** desenvolvido como teste prático, utilizando **Java (Spring Boot)** no back-end e **HTML/CSS/JavaScript** no front-end.  
A aplicação permite o cadastro de aprovados em concursos públicos, incluindo **upload e visualização de imagem**, persistência em banco de dados e listagem dos registros.

---

## 📌 Funcionalidades

- Cadastro de aprovados com:
  - Nome
  - E-mail
  - Telefone
  - Concursos aprovados
  - Upload de imagem
- Listagem de aprovados
- Visualização da imagem enviada
- Persistência dos dados
- API REST
- Front-end simples integrado à API

---

## 🧱 Arquitetura do Projeto

- **Back-end:** Java + Spring Boot (API REST)
- **Front-end:** HTML + CSS + JavaScript (Fetch API)
- **Banco de Dados:** H2 (em memória)
- **Upload de arquivos:** Armazenamento em pasta local (`uploads/`)

---

## 🛠️ Tecnologias Utilizadas

### Back-end
- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

### Front-end
- HTML5
- CSS3
- JavaScript (ES6+)
- Fetch API

---

## 📁 Estrutura de Pastas (Back-end)

src/main/java/com/example/demo
├── controller
│ └── AprovadoController.java
├── model
│ └── Aprovado.java
├── repo
│ └── AprovadoRepository.java
└── DemoApplication.java

Copiar código
src/main/resources
└── application.properties

Copiar código
uploads/
└── imagens enviadas pelo formulário

yaml
Copiar código

---

## ⚙️ Configurações Principais

### application.properties
```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:concursosdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update

spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB

app.upload-dir=uploads


▶️ Como Executar o Projeto
Pré-requisitos
Java JDK 17 ou superior

Maven (ou Maven Wrapper incluído)

VS Code (ou IDE de sua preferência)

Passos
Clone o repositório ou extraia o projeto

Abra a pasta raiz (onde está o pom.xml)

No terminal, execute:

bash
Copiar código
./mvnw spring-boot:run
(No Windows: mvnw.cmd spring-boot:run)

A aplicação estará disponível em:

arduino
Copiar código
http://localhost:8080
🔌 Endpoints da API
Criar aprovado (POST)
bash
Copiar código
POST /api/aprovados
Content-Type: multipart/form-data
Campos:

nome

email

telefone

concursos

imagem (opcional)

Listar aprovados (GET)
bash
Copiar código
GET /api/aprovados
Visualizar imagem (GET)
bash
Copiar código
GET /api/aprovados/{id}/imagem
🖥️ Front-end
O front-end é um arquivo HTML simples que:

Envia os dados via fetch

Lista os aprovados

Mostra a imagem usando o endpoint da API

Basta abrir o arquivo index.html no navegador (ou via Live Server).

🧰 Extensões Utilizadas no VS Code
Extension Pack for Java

Spring Boot Extension Pack

Language Support for Java™ by Red Hat

Debugger for Java

Maven for Java

(Opcional) Live Server (para servir o front-end)

✅ Status do Projeto
✔ Projeto funcional
✔ Back-end e front-end integrados
✔ Upload e exibição de imagens
✔ Persistência de dados

📌 Observações Finais
Este projeto foi desenvolvido com foco em simplicidade, clareza de código e boas práticas iniciais em aplicações full stack com Java e Spring Boot.

Possíveis evoluções:

Validação de campos

Autenticação e autorização

Persistência em banco relacional (PostgreSQL/MySQL)

Dockerização

Melhorias de layout

👤 Autor
Desenvolvido por Deewellys
