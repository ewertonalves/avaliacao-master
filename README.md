# Avaliação

### Tarefas

- Crie uma API pública em que seja possível listar, cadastrar, deletar e atualizar pessoas (C.R.U.D)
- Crie um endpoint público de busca por CPF
- Crie uma interface web. Sugestão: Angular2+, JSF 1.2


### O que esperamos ?
- Encaminhar o link do seu repositório do Github
- Explicação de como rodar localmente e também como seria possível realizar o deploy.
- Testes (Pelo menos 60% de cobertura)
- Legibilidade
- Escalabilidadea
- Commits pequenos
- Ver sua experiência codificando
- CLEAN CODE
- Keep it simple =] 

### Prazo de entrega
Após recebimento do e-mail o candidato terá 48hrs para entregar o projeto.

# Rodando o projeto
O projeto desenvolvido usando spring boot, o método para o projeto é o padrão do spring. Abra o projeto em seu Eclipse ou STS e rode o projeto usando o Dashboard Spring.

O projeto está coberto por testes unitários, se quiser testa-los pelos JUnit clique com o botão direito do mouse dentro da classe, depois clique em Run As > JUnit Test.

Para rodar no postman use as seguintes URLs
- Salvar: https://localhost:8080/api/v1/avaliacao-pamcary/salvar
- Consultar: https://localhost:8080/api/v1/avaliacao-pamcary/consultar
- Alterar: https://localhost:8080/api/v1/avaliacao-pamcary/alterar
- Apagar: https://localhost:8080/api/v1/avaliacao-pamcary/apagar

### Deploy
O Arquivo para deploy pode ser crado fazendo uso do Maven.

No Eclipse ou STS, clique com botão direito no projeto Run As > Maven build...

![image](https://user-images.githubusercontent.com/42001787/221670411-467ff2f7-d55c-4d48-a45e-afcbb0f05fec.png)

Após uma nova janela se abrirá como na imagem abaixo

![image](https://user-images.githubusercontent.com/42001787/221670846-3c5f7a00-7f4b-4569-ba5a-7bc46d4b37bb.png)

Assim será gerado o arquivo .war pra subir no servidor de preferência.


