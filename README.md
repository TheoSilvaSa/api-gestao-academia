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

    **Visão Geral dos Endpoints:**
    ![ListaEndpoints](https://github.com/user-attachments/assets/080d8a12-5688-43c9-8143-3b5f8f7c02c3)

* **Console do Banco de Dados H2:**
    Para visualizar os dados diretamente no banco.
    [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    * **JDBC URL:** `jdbc:h2:file:./gestao_academia_db`
    * **User Name:** `sa`
    * **Password:** `password`

---

## 📸 Prints dos Endpoints Testados (Swagger)

Abaixo estão os exemplos de testes realizados nos principais endpoints da aplicação, conforme solicitado no documento.

### Fluxo Principal de Criação de Dados

#### 1. Criação de um Novo Plano (`POST /api/v1/planos`)
![Criação de Plano](https://github.com/user-attachments/assets/52e5981c-55e4-41e3-a5e9-3d85dbbe7610)

#### 2. Criação de um Novo Aluno (`POST /api/v1/alunos`)
*OBS: na hora de criar, criei com id 1 por engano mas dei o comando UPDATE ALUNO SET PLANO_ID = 2 WHERE ID = 2;*
![Criação de Aluno](https://github.com/user-attachments/assets/4ee6538b-83a7-45a3-a19a-57aeb9a6b6a0)

#### 3. Criação de um Novo Treino (`POST /api/v1/treinos`)
![Criação de Treino](https://github.com/user-attachments/assets/bb616570-5096-4176-a020-a995fafb842a)

#### 4. Associação de Aluno a um Treino (`POST /api/v1/treinos/{treinoId}/alunos/{alunoId}`)
![Associação de Aluno e Treino](https://github.com/user-attachments/assets/794bdf5b-fb3e-454b-a31d-198a0aee907a)

#### 5. Registro de Pagamento (`POST /api/v1/alunos/{alunoId}/pagamentos`)
![Registro de Pagamento](https://github.com/user-attachments/assets/ad450ea3-cf4f-4245-948d-7e211d3119b0)

### Testes Adicionais (GET, PUT, DELETE)

#### 6. Consulta de Alunos (`GET /api/v1/alunos`)
*Este teste mostra a lista de alunos cadastrados, confirmando que a "Ana Carolina" foi criada e seu status inicial é `"ativo": true`.*
![Consulta de Alunos](https://github.com/user-attachments/assets/fd3dce7a-39d3-4705-9298-8126e3671023)

#### 7. Atualização de Aluno (`PUT /api/v1/alunos/{id}`)
*Este teste demonstra a funcionalidade de atualização, alterando o nome do aluno.*
![Atualização de Aluno](https://github.com/user-attachments/assets/21d97b80-b365-42fe-a56c-2fe229afea42)

#### 8. Inativação de Aluno (`DELETE /api/v1/alunos/{id}`)
*Este teste mostra o endpoint de inativação. O resultado `204 No Content` confirma o sucesso da operação.*
![Inativação de Aluno](https://github.com/user-attachments/assets/a020dc6f-eff9-42cf-8239-9728e738e572)

#### 9. Consulta de Pagamentos do Aluno (`GET /api/v1/alunos/{alunoId}/pagamentos`)
*Este teste lista todos os pagamentos registrados para um aluno específico.*
![Consulta de Pagamentos](https://github.com/user-attachments/assets/bce712e9-4a42-4e31-97a4-c3505cbb044a)


---

## 💾 Verificação no Banco de Dados (H2 Console)

As imagens abaixo confirmam que os dados criados via API foram persistidos corretamente no banco de dados H2.

**Consulta na tabela `ALUNO`:**
*A consulta exibe o aluno "Ana Carolina" e prova que a associação com o plano foi bem-sucedida ao registrar o `PLANO_ID` como 2.*
![Consulta na tabela Aluno](https://github.com/user-attachments/assets/149b4165-6750-4edd-afad-4300a32a9bf2)

**Consulta na tabela de Vínculo `ALUNO_TREINO_VINCULO`:**
*A consulta mostra a associação entre o aluno de ID 2 e o treino de ID 2.*
![Consulta na tabela Aluno-Treino](https://github.com/user-attachments/assets/2f983419-919f-4835-a1cd-9f8096e2d23c)

**Consulta na tabela `PAGAMENTO`:**
*A consulta mostra o pagamento registrado para o aluno de ID 2.*
![Consulta na tabela Pagamento](https://github.com/user-attachments/assets/06aac244-f1bc-491d-95da-cb697688ebb4)
