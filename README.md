# BioparkAcademy_Restfull

# APRESENTAÇÃO

Este projeto consiste em atender os requisitos estabelecidos por um desafio prático proposto pela equipe de recrutamento e seleção do Biopark. Em um processo seletivo para trainee do maior parque tecnológico privado do Brasil, um parque com vocação em inovação nas áreas de educação, pesquisa e negócios.

Para mais informações sobre o Biopark: https://www.biopark.com.br/ 

# ÍNDICE

1. Síntese;
2. Requisitos Mínimos;
3. Tecnologias;
4. Diagrama Entidade-Relacionamento - DER;
5. Unified Modeling Language - UML
6. Controllers e Endpoints;
7. Entidades;
8. Data Transfer Object - DTO;
9. Database;
10. Base de dados;
11. Guia de teste;
12. Licença;
13. Contatos.

## 1. SÍNTESE

A prova prática, chamada de “Desafio Tech”, visa testar as habilidades de programação e desenvolvimento e, além disso, conhecer o estilo de trabalho do candidato a trainee do Biopark. Assim, solicita a construção do primeiro ‘sprint’ de um sistema de gestão acadêmica. Portanto, determina os seguintes termos:

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
- IDE e outras ferramentas: NetBeans, Maven, Postman, Swagger/OpenAPI, BrModelo, Astah e GitHub;

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
- A máquina virtual Java (JVM) roda diversas outras linguagens;
- Mercado amplo e aquecido;
- Mundialmente popular;
- Comunidade atuante na confecção de materiais de estudo, palestras, eventos e cursos;

## 4. DIAGRAMA ENTIDADE-RELACIONAMENTO - DER

### Modelo Conceitual

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145690139-36c583bf-84aa-4ca4-8e90-0995059c33b8.png" width="700" />
</div>

### Modelo Lógico

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145690340-66f7c92e-2f0b-443c-b989-3814b222d1c8.png" width="700" />
</div>

## 5. UNIFIED MODELING LANGUAGE - UML

### Caso de Uso

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145696031-1d3f68a8-c4f1-4338-8f62-9af25b410b0c.png" width="800" />
</div>

### Diagrama de Classe

<div align="center">
  <img src="https://user-images.githubusercontent.com/64662590/145709950-16974a13-1d32-4f17-9b91-eee8480c71ed.png" width="900" />
</div>

## 6. CONTROLLERS E ENDPOINTS

- AlunoController: cinco endpoints foram construídos dentro da classe de controle de Aluno. Neste caso, do 'desafio tech', por uma questão de praticidade e simplicidade, optei por não criar uma camada de serviços para abarcar as lógicas e relações com a infraestrutura (database). Logo, mantive tudo centralizado na camada de controlle. Porém, se necessário, isso pode ser refatorado.
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

Requisita alunos com paginação: retorna todos os alunos por paginação customizada ou padrão. Você pode inserir os detalhes de paginação ou, no caso de não inserir, retornará todos os alunos paginados pela paginação padrão (pré-definida no código). Também há a possibilidade de requisitar alunos por data de nascimento com paginação: permite inserir data de nascimento como padrão de busca.  

- GET - /alunos/v1/consultar/{id}

Requisita um aluno: busca um aluno pelo atributo ID e há resposta padronizada em caso de ID inexistente.

- POST - /alunos/v1/cadastrar

Efetua o cadastro de aluno na base de dados. E os dados a serem inseridos passam por validação, como, por exemplo, validação de CPF, entre outros.

- PUT - /alunos/v1/atualizar/{id}

Efetua a atualização cadastral, por meio do ID, de um aluno presente na base de dados. Também há resposta padronizada para IDs inexistentes.

- DELETE - /alunos/v1/deletar/{id}

Remove um aluno, por meio do ID, da base de dados. Também há resposta padronizada para IDs inexistentes.

- GET - /cursos/v1/consultar

Requisita cursos com paginação: retorna todos os cursos por paginação customizada ou padrão. Você pode inserir os detalhes de paginação ou, no caso de não inserir, retornará todos os cursos paginados pela paginação padrão (pré-definida no código). 

- GET - /matriculas/v1/consultar

Consulta matrículas com paginação: retorna todas as matrículas por paginação customizada ou padrão. Retorna as matrículas sem os respectivos alunos e cursos.

## 7. ENTIDADES

- Aluno: id, nome, cpf, dataNascimento, dataCadastro e statusMatricula;
- Curso: id, nome, cargaHoraria e preco;
- Matricula: id, numMatricula, dataMatricula, curso e aluno;

## 8. DATA TRANSFER OBJECT - DTO

Os DTOs são um padrão usado para transportar dados entre subsistemas de um software. São objetos simples e, geralmente, sem comportamento ou lógica de negócio. E, neste caso do BioparkAcademy, foram criados dois tipos de DTOs, os DTOs de entrada (in) e os DTOs de saída de dados (out). Os DTOs de entrada auxiliam no transporte de dados para dentro do sistema e os DTOs de saída auxiliam no transporte para fora do sistema.

- AlunoDtoIn: usado para transferir informações do consumer/formulário para a API/base de dados.
- AlunoDtoOut: usado para recuperar informações da base de dados para o consumer.
- CursoDtoOut: usado para recuperar informações da base de dados para o consumer.
- MatriculaDtoOut: usado para recuperar informações da base de dados para o consumer.

## 9. DATABASE

- H2: utilizei banco de dados em memória para todo o processo de desenvolvimento da API Rest. A configuração está logo abaixo:
~~~
#Datasource
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:bioparkacademy
spring.datasource.username=sa
spring.datasource.password=

#JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.defer-datasource-initialization=true

#H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
~~~
- PostgreSQL: incluído apenas na fase final do desenvolvimento. A configuração está logo abaixo:
~~~
#Datasource
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/bioparkacademy
spring.datasource.username=postgres
spring.datasource.password=123456

#JPA
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.defer-datasource-initialization=true
~~~

## 10. BASE DE DADOS

Foi criada uma base de dados no arquivo data.sql. Para realizar os testes necessários com o Swagger/OpenAPI e ou Postman. E o SQL é o seguinte:
~~~
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Maria Santana', '509.361.220-05', '2000/01/05', '2021-12-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Agenor Munder', '083.483.040-02', '1990/08/17', '2019-10-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Frank Belone', '102.843.980-63', '2004/05/08', '2020-08-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Roberta Zanini', '053.783.560-16', '1975/12/10', '2015-11-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Joaquim Montana', '136.259.960-30', '1979/07/16', '2011-05-11T09:57:25.8375059');

INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Vanessa Lerh', '405.648.340-09', '1984/01/18', '2002-12-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Isabele Henning', '761.986.540-36', '1987/02/22', '2005-01-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Jose Brasil', '934.797.960-01', '1989/03/23', '2007-03-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Alexandre Pardim', '223.641.300-93', '1993/09/09', '2001-02-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Gustavo Silas', '010.600.520-08', '1994/08/21', '2008-07-11T09:57:25.8375059');

INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Bruno Severo', '613.934.990-74', '1996/07/07', '2021-02-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Luciana Tavares', '646.272.730-61', '1999/06/04', '2021-05-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Marcia Costa', '835.627.070-70', '2002/04/28', '2018-06-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Elisabeth Ginger', '561.705.860-60', '2006/05/25', '2019-09-11T09:57:25.8375059');
INSERT INTO ALUNOS(nome, cpf, data_nascimento, data_cadastro) VALUES('Vinicius Abricate', '398.863.790-49', '2001/03/12', '2014-08-11T09:57:25.8375059');

INSERT INTO CURSOS(nome, carga_horaria) VALUES('Java', 1700);
INSERT INTO CURSOS(nome, carga_horaria) VALUES('Spring Framework', 1250);
INSERT INTO CURSOS(nome, carga_horaria) VALUES('Jakarta 9', 980);
INSERT INTO CURSOS(nome, carga_horaria) VALUES('API Rest', 1050);
INSERT INTO CURSOS(nome, carga_horaria) VALUES('Database', 1100);

INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('1-6-1122021', '2021-02-11T09:57:25.8375059', 1, 6);
INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('5-15-1122021', '2021-02-11T09:57:25.8375059', 5, 15);
INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('4-1-1122021', '2021-02-11T09:57:25.8375059', 4, 1);
INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('2-9-1122021', '2021-02-11T09:57:25.8375059', 2, 9);
INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('3-12-1122021', '2021-02-11T09:57:25.8375059', 3, 12);
INSERT INTO MATRICULAS(num_matricula, data_matricula, curso_id, aluno_id) VALUES('2-4-1122021', '2021-02-11T09:57:25.8375059', 2, 4);
~~~

## 11. GUIA DE TESTE

A API Rest pode ser testada de duas formas: pelo Swagger/OpenAPI e pelo Postman;

1. Clone o projeto em sua IDE;
2. Prefira o database h2 para os testes (a configuração está na sessão de database). Caso contrário, precisará inserir a base de dados no PostgreSQL;
3. Dê Run no projeto;
4. Use os dados abaixo para testar no OpenAPI (http://localhost:8080/swagger-ui.html) ou no Postman. Minha preferência é pelo uso do Postman;

Testes para consultar Alunos:
- GET - http://localhost:8080/alunos/v1/consultar
- GET - http://localhost:8080/alunos/v1/consultar?page=1&size=4&sort=id,asc
- GET - http://localhost:8080/alunos/v1/consultar/2
- POST - http://localhost:8080/alunos/v1/cadastrar
~~~
{
    "nome":"Manoel Calabrim",
    "cpf":"109.415.110-65",
    "dataNascimento":"1999/02/13"
}
~~~
Testar para atualizar Alunos:
- PUT - http://localhost:8080/alunos/v1/atualizar/15
~~~
{
    "nome":"Carlos Valar",
    "cpf":"102.423.590-43",
    "dataNascimento":"2004/01/21"
}
~~~
Testar para apagar Alunos:
- DELETE - http://localhost:8080/alunos/v1/deletar/15

Testes para consultar Cursos:
- GET - http://localhost:8080/cursos/v1/consultar
- GET - http://localhost:8080/cursos/v1/consultar?page=1&size=2&sort=id,asc

Testes para consultar Matrículas:
- GET - http://localhost:8080/matriculas/v1/consultar
- GET - http://localhost:8080/matriculas/v1/consultar?page=1&size=2&sort=id,asc

## 12. LICENÇA

Nome: GPLv3 </br>
URL: https://www.gnu.org/licences/gpl-3.0.html

## 13. CONTATOS

Autor: Junior Martins </br>
LinkedIn: https://www.linkedin.com/in/juniorsmartins/


