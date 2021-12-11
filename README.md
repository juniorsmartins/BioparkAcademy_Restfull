# BioparkAcademy_Restfull

# APRESENTAÇÃO

Este projeto consiste em atender os requisitos estabelecidos por um desafio prático proposto pela equipe de recrutamento e seleção do Biopark. Em um processo seletivo para trainee do maior parque tecnológico privado do Brasil, um parque com vocação em inovação nas áreas de educação, pesquisa e negócios.

Para mais informações sobre o Biopark: https://www.biopark.com.br/ 

# ÍNDICE

1. Síntese;
2. Requisitos Mínimos;
3. Tecnologias;
4. Controller e Endpoints;
5. Diagrama Entidade-Relacionamento - DER;
6. Entidades;
7. Data Transfer Object - DTO;
8. Database;
9. Guia de teste;

## 1. SÍNTESE

Chamado de “Desafio Tech”, a prova prática visa testar as habilidades de programação e desenvolvimento e, além disso, conhecer o estilo de trabalho do candidato a trainee do Biopark. Assim, solicita a construção do primeiro ‘sprint’ de um sistema de gestão acadêmica. Portanto, determina os seguintes termos:

## 2. REQUISITOS MÍNIMOS

- A primeira sprint consiste no desenvolvimento de dois endpoints. O primeiro endpoint para registro do aluno e o segundo endpoint para consulta do aluno. Os endpoints devem ter no mínimo os seguintes campos: nome; CPF; data de nascimento;
- Linguagens: preferência por Java, Python ou JavaScript, mas pode ser qualquer outra condicionado a explicação do motivo da escolha;
- Banco de dados: utilizar MySql ou PostgreSql;
- Banco de dados e tabelas: a criação do banco e das tabelas fica a critério do candidato, seja via script ou aplicação;
- APIs: devem seguir o modelo Restful com formato Json;
- Seguir as boas práticas de programação.
- Envio: o desafio deve ser enviado preferencialmente como repositório Git público (Github, Gitlab ou Bitbucket), com commits pequenos e bem descritos. Ou enviado como arquivo compactado (Zip ou Tar);
- O repositório deve estar com modelo de licença de código aberto.

## 3. TECNOLOGIAS

- Linguagem de programação: Java;
- Framework: Spring (Boot, Web, Data Jpa, Validation, Cache e DevTools);
- Banco de Dados: H2 em desenvolvimento e PostgreSql em produção;
- IDE e outras ferramentas: NetBeans, Maven, Postman, Swagger/OpenAPI e GitHub;

### Motivação por Java:

- Java é uma linguagem de programação e uma plataforma de desenvolvimento de software. O qual permite desenvolver software para desktop, mobile, web e para diversos eletrônicos (televisões, eletrodomésticos, cartões bancários e naves espaciais);
- Portabilidade - rodam em qualquer sistema operacional e em qualquer hardware;
- Tipagem Estática - fornece maior segurança ao código;
- Multi-threaded - capacidade de suportar processamentos múltiplos;
- Gratuidade - linguagem e ambientes de produção gratuitos;
- Internacionalização - suporta nativamente caracteres Unicode;
- Elegância, organização e formalidade do código;
- Multiparadigma;
- Vasta biblioteca de rotinas e APIs;
- Variedade de frameworks;
- A máquina virtual Java roda diversas outras linguagens;
- Mercado amplo e aquecido;
- Mundialmente popular;
- Comunidade atuante na confecção de materiais de estudo, palestras, eventos e cursos;

## 4. CONTROLLERS E ENDPOINTS

- AlunoController: todos os endpoints foram construídos dentro da classe de controle de Aluno. Neste caso, do 'desafio tech', por uma questão de praticidade e simplicidade, optei por não criar uma camada de serviços para abarcar as lógicas e relações com a infraestrutura (database). Logo, mantive tudo centralizado na camada de controlle.
- CursoController: possui um endpoint para consultar os cursos presentes na base de dados.
- MatriculaController: possui um endpoint para consultar as matrículas registradas na base de dados.

### Verbos e Endpoints

- GET - /alunos/v1/consultar
- GET - /alunos/v1/consultar/{id}
- POST - /alunos/v1/cadastrar
- PUT - /alunos/v1/atualizar/{id}
- DELETE - /alunos/v1/deletar/{id}
- GET - /cursos/v1/consultar
- GET - /matriculas/v1/consultar

### Descritivos

- GET - /alunos/v1/consultar

Requisita alunos com paginação: retorna todos os alunos por paginação customizada ou padrão. Você pode inserir os detalhes de paginação ou, no caso de não inserir, retornará todos os alunos paginados pela paginação padrão (pré-definida no código). 
Requisita alunos por data de nascimento com paginação: permite inserir data de nascimento como padrão de busca de todos. Bem como faz uso de paginação customizada ou padrão.  

- GET - /alunos/v1/consultar/{id}

Requisita um aluno: busca um aluno pelo atributo ID e há resposta padronizada em caso de ID inexistente.

- POST - /alunos/v1/cadastrar

Efetua o cadastro de aluno na base de dados. E os dados a serem inseridos passam por validação, como, por exemplo, validação de CPF, entre outros.

- PUT - /alunos/v1/atualizar/{id}

Efetua a atualização cadastral, por meio do ID, de um aluno presente na base de dados. Também há resposta padronizada para IDs inexistentes.

- DELETE - /alunos/v1/deletar/{id}

Remove um aluno, por meio do ID, da base de dados. Também há resposta padronizada para IDs inexistentes.

- GET - /cursos/v1/consultar

Requisita cursos com paginação: retorna todos os alunos por paginação customizada ou padrão. Você pode inserir os detalhes de paginação ou, no caso de não inserir, retornará todos os cursos paginados pela paginação padrão (pré-definida no código). 

- GET - /matriculas/v1/consultar

Consulta matrículas com paginação: retorna todas as matrículas por paginação customizada ou padrão. Retorna apenas as matrículas sem lista de alunos e cursos.

## 5. DIAGRAMA ENTIDADE-RELACIONAMENTO - DER

### Modelo Conceitual

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145690139-36c583bf-84aa-4ca4-8e90-0995059c33b8.png" width="700" />
</div>

### Modelo Lógico

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145690340-66f7c92e-2f0b-443c-b989-3814b222d1c8.png" width="700" />
</div>

## 6. ENTIDADES

- Aluno: id, nome, CPF, dataNascimento, dataCadastro e statusMatricula;
- Curso: id, nome, cargaHoraria e preco;
- Matricula: id, numMatricula, dataMatricula, curso e aluno;

## 7. DATA TRANSFER OBJECT - DTO

Os DTOs são um padrão usado para transportar dados entre subsistemas de um software. São objetos simples, sem qualquer comportamento ou lógica de negócio. E, neste caso, foram criados dois tipos de DTOs, os DTOs de entrada (in) e os DTOs de saída de dados (out).

- AlunoDtoIn: usado para transferir informações do consumer/formulário para a API/base de dados.
- AlunoDtoOut: usado para recuperar informações da base de dados para o consumer.
- CursoDtoOut: usado para recuperar informações da base de dados para o consumer.
- MatriculaDtoOut: usado para recuperar informações da base de dados para o consumer.

## 8. DATABASE

- H2: utilizei banco de dados em memória para todo o processo de desenvolvimento da API Rest.
- PostgreSQL: incluído apenas na fase final do desenvolvimento.

## 9. GUIA DE TESTE

1. 
2. 

Testes para consultar Alunos:
- GET - http://localhost:8080/alunos/v1/consultar
- GET - http://localhost:8080/alunos/v1/consultar?page=1&size=4&sort=id,asc
- GET - http://localhost:8080/alunos/v1/consultar/2
- POST - http://localhost:8080/alunos/v1/cadastrar
var useEsteJson = 
{
    "nome":"Manoel Calabrim",
    "cpf":"109.415.110-65",
    "dataNascimento":"1999/02/13"
}
Testar para atualizar Alunos:
- PUT - http://localhost:8080/alunos/v1/atualizar/15
var useEsteJson =
{
    "nome":"Pablo Avatar",
    "cpf":"102.423.590-43",
    "dataNascimento":"2004/01/21"
}
Testar para apagar Alunos:
- DELETE - http://localhost:8080/alunos/v1/deletar/15

Testes para consultar Cursos:
- GET - http://localhost:8080/cursos/v1/consultar
- GET - http://localhost:8080/cursos/v1/consultar?page=1&size=2&sort=id,asc

Testes para consultar Matrículas:
- GET - http://localhost:8080/matriculas/v1/consultar
- GET - http://localhost:8080/matriculas/v1/consultar?page=1&size=2&sort=id,asc








