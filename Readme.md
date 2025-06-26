# 🍃🌀 Projeto **Naruto I** - API REST 🥷🔥

Bem-vindo(a) ao **Naruto I**, uma API REST inspirada no universo ninja de **Naruto**!  
Aqui você pode criar, listar, atualizar e remover personagens, assim como um verdadeiro Hokage 👑🍜.

---

🏯 **Estrutura da Vila Ninja**

com.desafio.narutoI  
├── controller 🧭  
├── dto 🎴  
├── entidades 👤  
├── mapper 🔄  
├── repositories 📂  
└── services 🛠️

## ⚡️✨ **Funcionalidades Shinobi**

- 🗂️ **Listar todos os personagens**
- 🔍 **Buscar personagem por ID**
- 🆕 **Criar novo personagem**
- 🔄 **Atualizar personagem existente**
- 🗑️ **Deletar personagem**
- 🉐 **Suporte para tipos de ninjas:**
    - Ninjutsu ⚔️
    - Taijutsu 🥋
    - Genjutsu 🧿

---

## ⚙️ **Tecnologias usadas para criar essa Vila Oculta**

- ☕ **Java 17**
- 🌱 **Spring Boot 3**
- 🐍 **Utilização de objectMapper**
- 💻 **H2 Database (banco em memória)**
- 📦 **Maven**
- 🦾 **Lombok**

---

## 🏃‍♂️💨 **Executando a API**

1️⃣ Clone o repositório:
```bash
git clone https://github.com/seu-usuario/narutoI.git
```
2️⃣ Entre no diretório do projeto:

```bash
cd narutoI
```
3️⃣ Inicie o Jutsu de Execução:
```bash
./mvnw spring-boot:run
```
4️⃣ Acesse o console do H2 para vigiar seu clã:
🔗 http://localhost:8080/h2-console

```bash
JDBC URL: jdbc:h2:mem:naruto

User: sa

Senha: (em branco)
```

🗺️ Mapa de Endpoints Shinobi

| ⚔️ Método  | 🔗 Endpoint         | 📃 Descrição             |
| ---------- | ------------------- | ------------------------ |
| **GET**    | `/personagens`      | Ver todos os ninjas      |
| **GET**    | `/personagens/{id}` | Ver detalhes de um ninja |
| **POST**   | `/personagens`      | Invocar novo ninja       |
| **PUT**    | `/personagens/{id}` | Treinar ninja            |
| **DELETE** | `/personagens/{id}` | Exilar ninja             |



> 🧪 **Testes de Combate Shinobi**
>
> ✔️ **Testes unitários para:**
>
> - Services ⚙️
> - Entidades 📂
> - Integração 🔄
> - 🛡️ Protege sua vila contra bugs sorrateiros do Orochimaru 🐍!
```

> 📜 **Notas do Hokage**
>
> - 🌙 O banco H2 é em memória, então reinicia a cada execução.
> - 🌀 Uso de DTO + Mapper separa REST da camada de persistência.
> - 💪 O update é manual, para treinar cada ninja com disciplina de Konoha!
```


Projeto criado para fortalecer habilidades em Programação Orientada a Objetos e API REST, com a força de vontade de um verdadeiro shinobi 🍃🔥.

“Eu nunca volto atrás na minha palavra... Esse é o meu jeito ninja de ser!” — By Naruto Uzumaki 🍜🦊
