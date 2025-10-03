# API REST de Gestão de Academia

## 📖 Descrição da Solução

Esta é uma API REST para o gerenciamento de uma academia, desenvolvida como projeto de avaliação utilizando **Spring Boot** e **Java 17**. A API permite o controle completo sobre alunos, planos, treinos e pagamentos, seguindo as melhores práticas de desenvolvimento de software.

O projeto foi estruturado em uma **arquitetura de camadas** (Controller, Service, Repository) para garantir a separação de responsabilidades e facilitar a manutenção. Todos os endpoints utilizam **DTOs** para a comunicação, assegurando que as entidades do banco de dados não sejam expostas.

---

## 🚀 Instruções para Rodar o Projeto

### Pré-requisitos
* Java 17 (JDK)
* Apache Maven

### Passos para Execução
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/TheoSilvaSa/api-gestao-academia.git](https://github.com/TheoSilvaSa/api-gestao-academia.git)
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd api-gestao-academia
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    mvn spring-boot:run
    ```
A aplicação estará rodando em `http://localhost:8080`.

---

## ⚙️ Acessando os Recursos da API

* **Documentação Interativa (Swagger UI):**
    Para testar todos os endpoints de forma visual.
    [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

* **Console do Banco de Dados H2:**
    Para visualizar os dados diretamente no banco.
    [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    * **JDBC URL:** `jdbc:h2:file:./gestao_academia_db`
    * **User Name:** `sa`
    * **Password:** `password`

---

## 📸 Prints dos Endpoints Testados (Swagger)

Abaixo estão os exemplos de testes realizados nos principais endpoints da aplicação, conforme solicitado no documento.

### 1. Criação de um Novo Plano (`POST /api/v1/planos`)
![Criação de Plano](<img width="1918" height="967" alt="Image" src="https://github.com/user-attachments/assets/52e5981c-55e4-41e3-a5e9-3d85dbbe7610" />)

### 2. Criação de um Novo Aluno (`POST /api/v1/alunos`)
![Criação de Aluno](<img width="1918" height="1033" alt="Image" src="https://github.com/user-attachments/assets/4ee6538b-83a7-45a3-a19a-57aeb9a6b6a0" />)

### 3. Associação de Aluno a um Treino (`POST /api/v1/treinos/{treinoId}/alunos/{alunoId}`)
![Associação de Aluno e Treino](<img width="1918" height="1027" alt="Image" src="https://github.com/user-attachments/assets/bb616570-5096-4176-a020-a995fafb842a" />)

### 4. Registro de Pagamento (`POST /api/v1/alunos/{alunoId}/pagamentos`)
![Registro de Pagamento](<img width="1918" height="1028" alt="Image" src="https://github.com/user-attachments/assets/794bdf5b-fb3e-454b-a31d-198a0aee907a" />)

---

### 💾 Verificação no Banco de Dados (H2 Console)

As imagens abaixo confirmam que os dados criados via API foram persistidos corretamente no banco de dados H2.

**Consulta na tabela `ALUNO` e `PLANO`:**
*A consulta mostra o aluno "Ana Carolina" associado ao `PLANO_ID` 2.*
![Consulta na tabela Aluno](<img width="1918" height="1077" alt="Image" src="https://github.com/user-attachments/assets/8a51f321-0a03-4d48-adbb-2201b7d46348" />)

**Consulta na tabela de Vínculo `ALUNO_TREINO_VINCULO`:**
*A consulta mostra a associação entre o aluno de ID 2 e o treino de ID 2.*
![Consulta na tabela Aluno-Treino](<img width="1918" height="1081" alt="Image" src="https://github.com/user-attachments/assets/2f983419-919f-4835-a1cd-9f8096e2d23c" />)

**Consulta na tabela `PAGAMENTO`:**
*A consulta mostra o pagamento registrado para o aluno de ID 2.*
![Consulta na tabela Pagamento](<img width="1918" height="1077" alt="Image" src="https://github.com/user-attachments/assets/609c722e-e4e4-47cf-ae67-2df86779738f" />)
