# AtividadeCRUD-RPG

---- OQUE FOI USADO? ----

-Java

-H2 database

-Spring WEB

-Spring DATA JPA

-Swagger UI

-Rota Swagger: http://localhost:8090/swagger-ui/index.html#/

# Features Solicitadas

1. Cadastrar Personagem;
2. Cadastrar Item Mágico;
3. Listar Personagem;
4. Buscar Personagem por Identificador;
5. Atualizar Nome de Guerreiro por Identificador;
6. Remover Personagem;
7. Listar Itens Mágicos;
8. Buscar Item Mágico por Identificador;
9. Adicionar Item Mágico ao Personagem;
10. Listar Itens Mágicos por Personagem;
11. Remover Item Mágico do Personagem;
12. Buscar Amuleto do Personagem;

-----------------------------------------------------------------

**1. Cadastrar Personagem - Rota Definida POST -> http://localhost:8090/personagem**

Foi feita a validação de que, ao criar o Personagem durante o POST, ele terá 10 pontos para distribuir entre Força e Defesa, da forma que desejar, desde que não ultrapasse os 10 pontos disponíveis (ex: 5-5, 6-4, 10-0). Caso ele ultrapasse os pontos, é retornado um bad request com uma mensagem explicando o erro.

Também é feita a validação para conferir se o usuário informou uma classe de personagem válida. Caso seja uma fora das opções fixas, é retornado um erro informando.

Exemplo mostrando um POST com retorno 201 e os possíveis erros:
![1](https://github.com/user-attachments/assets/0ed968c3-4fde-40c0-82d5-688db29acfcf)


**2. Cadastrar Item Mágico - Rota Definida POST -> http://localhost:8090/item_magico**

Foi feita a validação de que, ao criar um Item Mágico via POST:

Se o item for do tipo Arma, a Defesa será obrigatoriamente zero.

Se for do tipo Armadura, a Força será obrigatoriamente zero.

Se for do tipo Amuleto, poderá ter Força e Defesa (máximo de 10 pontos cada).

Não podem existir itens com Força e Defesa iguais a zero.

Exemplo mostrando um POST com retorno 201 e os possíveis erros:
![2](https://github.com/user-attachments/assets/25eb95e2-7099-4948-b2b4-e9f14182ef30)


**3. Listar Personagem - Rota Definida GET -> http://localhost:8090/personagem**

Foi adicionada a função de somar os atributos Defesa e Força apenas quando a lista de personagens é chamada, mantendo os valores originais e somando os itens mágicos apenas para exibição.

Exemplo mostrando um GET com retorno 200 e os valores sendo calculados:
![3](https://github.com/user-attachments/assets/5092cda9-e3d4-4c6f-91e0-49515800105f)


**4. Buscar Personagem por Identificador - Rota Definida GET -> http://localhost:8090/personagem/{id}**

Foi adicionada a função de somar os atributos Defesa e Força apenas quando o personagem é consultado. O GET espera um ID válido, e um erro é retornado caso o personagem não seja encontrado.

Exemplo mostrando um GET com retorno 200, os valores calculados e o possível erro:
![4](https://github.com/user-attachments/assets/75efc9ac-647b-4dbe-b580-368a071e0869)


**5. Atualizar Nome de Personagem por Identificador - Rota Definida PUT -> http://localhost:8090/personagem/{id}**

Atualiza o nome de um personagem com base no ID, retornando apenas o campo atualizado. Se o ID não for encontrado, um erro é exibido.

Exemplo mostrando um PUT com retorno 200 e o possível erro:
![5](https://github.com/user-attachments/assets/5a0ab7b2-3425-4a20-b584-697170f1e285)


**6. Remover Personagem - Rota Definida DELETE -> http://localhost:8090/personagem/{id}**

Remove um personagem com base no ID e retorna o personagem excluído. Se o ID não for encontrado, é exibido um erro.

Exemplo mostrando um DELETE com retorno 200 e o possível erro:
![6](https://github.com/user-attachments/assets/a3722aaa-2563-4463-a4bc-f47f3c2bf87e)


**7. Listar Itens Mágicos - Rota Definida GET -> http://localhost:8090/item_magico**

Retorna todos os itens mágicos cadastrados.

Exemplo mostrando o GET com retorno 200:
![7](https://github.com/user-attachments/assets/d50c5f44-835a-492d-be0c-1e973220b503)

**8. Buscar Item Mágico por Identificador - Rota Definida GET -> http://localhost:8090/item_magico/{id}**

Busca um item mágico específico por ID. Um erro é exibido caso o item não seja encontrado.

Exemplo mostrando o GET com retorno 200 e o possível erro:
![8](https://github.com/user-attachments/assets/4b217832-2674-4db0-94f3-6d25e19626e6)


**9. Adicionar Item Mágico ao Personagem - Rota Definida POST -> http://localhost:8090/item_magico/{id}/AddItens/{iditem}**

Adiciona um item mágico a um personagem. Cada personagem pode ter apenas um amuleto — a regra é validada, e um bad request é retornado caso viole a restrição. Também são tratados erros para ID de personagem ou item não encontrados.

Exemplo mostrando o POST com retorno 200 e os possíveis erros:
![9](https://github.com/user-attachments/assets/857097dd-87a5-4c44-b517-b0f9a4d24500)


**10. Listar Itens Mágicos por Personagem - Rota Definida GET -> http://localhost:8090/item_magico/{PersonagemId}/Itens_do_personagem**

Retorna todos os itens mágicos de um personagem. Um erro é exibido caso o personagem não seja encontrado.

Exemplo mostrando o GET com retorno 200 e o possível erro:
![11](https://github.com/user-attachments/assets/056c40ba-1644-4940-9da6-d15cceaa370d)


**11. Remover Item Mágico do Personagem - Rota Definida POST -> http://localhost:8090/item_magico/{id}/RemoverItens/{iditem}**

Remove um item mágico específico de um personagem. Um erro é exibido caso o item ou o personagem não seja encontrado.

Exemplo mostrando o POST com retorno 200 e o possível erro:
![10](https://github.com/user-attachments/assets/2e1e2597-065d-4bdd-89a2-14081572e67f)


**12. Buscar Amuleto do Personagem - Rota Definida GET -> http://localhost:8090/item_magico/{PersonagemId}/Procurar_Amuleto**

Verifica se o personagem possui um amuleto. Um erro é exibido caso o personagem não seja encontrado. Se ele não tiver um amuleto, é retornado um Not Found informando a ausência.

Exemplo mostrando o GET com retorno 200, o possível erro e o caso de ausência de amuleto:
![12](https://github.com/user-attachments/assets/4532ce7f-2922-4f84-ad41-148472858d09)



