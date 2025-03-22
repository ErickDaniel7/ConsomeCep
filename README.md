# **ConsomeCEP**

## 📌 **Objetivo do Projeto**

O projeto **ConsomeCEP** tem como objetivo desenvolver uma aplicação em Java que consulta endereços a partir do CEP informado pelo usuário, utilizando a API **ViaCEP**. Caso o CEP não esteja cadastrado, o sistema salva as informações no banco de dados PostgreSQL para consultas futuras. Se o CEP já estiver registrado, o sistema apenas exibe os dados armazenados.

## 🔧 **Tecnologias Utilizadas**

- **Java 17+**: Linguagem de programação utilizada no desenvolvimento da aplicação.
- **API ViaCEP**: API pública para consulta de endereços a partir do CEP.
- **PostgreSQL**: Banco de dados utilizado para armazenar os endereços consultados.
- **JPA (Jakarta Persistence API)**: Framework para gerenciamento de persistência dos dados no banco de dados.
- **Maven**: Ferramenta de automação de construção (build) e gerenciamento de dependências.
- **JSON**: Formato utilizado para troca de dados entre a aplicação e a API.

## 🛠️ **Como Executar o Projeto**

### **Passo 1: Clone o Repositório**

Primeiro, faça o clone do repositório para a sua máquina local:

```bash
git clone https://github.com/seu-usuario/consomeCEP.git
```

### **Passo 2: Acesse o Diretório do Projeto**

Entre no diretório do projeto clonado:

```bash
cd consomeCEP
```

### **Passo 3: Compile o Projeto**

Compile o projeto usando o Maven:

```bash
mvn clean install
```

### **Passo 4: Configure o Banco de Dados**

Configure o PostgreSQL conforme abaixo:

• Crie um banco de dados chamado endereco no PostgreSQL.

• Atualize as credenciais no arquivo persistence.xml (caso necessário):

```bash
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5433/endereco"/>
<property name="jakarta.persistence.jdbc.user" value="postgres"/>
<property name="jakarta.persistence.jdbc.password" value="sua-senha"/>
```

### **Passo 5: Execute o Projeto**

Para executar o projeto, use o Maven:

```bash
mvn exec:java -Dexec.mainClass="br.unipar.programacaoweb.ConsomeCEP"
```

O programa irá solicitar que você digite um CEP, consultar a API ViaCEP e, se o CEP não existir no banco de dados, irá salvá-lo para futuras consultas.

<br>

<br>

## 🎯 **Como Funciona o Projeto**

1. **O usuário digita um CEP**.
2. O programa **consulta a API ViaCEP** para obter as informações de endereço.
3. Se o **CEP já estiver no banco de dados**:
   - Exibe os **dados armazenados**.
   - **Atualiza a data da consulta** no banco.
4. Se o **CEP não estiver no banco de dados**:
   - **Salva as informações** no banco de dados.
   - Exibe as **informações do novo CEP**.
5. O programa **pergunta se o usuário quer realizar outra consulta**:
   - Se **Sim**, o processo reinicia.
   - Se **Não**, o programa é **encerrado**.
