ConsomeCEP

O que faz?
Consulta endereços pelo CEP usando a API ViaCEP.
Salva os dados no banco de dados para consultas futuras.

Passo a Passo
1. Usuário digita um CEP.
2. Programa consulta o CEP na API ViaCEP.
3. Mostra as informações do endereço.
4. Verifica se o CEP já está no banco de dados:
 Se **não estiver**, salva o CEP.
  Se **já existir**, avisa o usuário.
6. Pergunta se o usuário quer continuar:
  Se **sim**, volta ao passo 1.
  Se **não**, encerra.
     
Como rodar?
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/consomeCEP.git
2. entra na pasta
   cd consomeCEP
3.Compile
  mvn clean install
4.Execute o programa
 mvn exec:java -Dexec.mainClass="br.unipar.programacaoweb.ConsomeCEP"

Pré-requisitos
- Java
- Banco de dados (PostgreSQL)
- Dbvear
- Maven
- JSON

