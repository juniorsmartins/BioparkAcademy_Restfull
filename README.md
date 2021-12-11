# BioparkAcademy_Restfull

# APRESENTAÇÃO

Este projeto consiste em atender os requisitos estabelecidos por um desafio prático proposto pela equipe de recrutamento e seleção do Biopark. Em um processo seletivo para trainee do maior parque tecnológico privado do Brasil, um parque com vocação em inovação nas áreas de educação, pesquisa e negócios.

Para mais informações sobre o Biopark: https://www.biopark.com.br/ 

## ÍNDICE

* 1 - Síntese;
* 2 - Requisitos Mínimos;
* 3 - Tecnologias;
* 4 - Endpoints;

## 1 - SÍNTESE

Chamado de “Desafio Tech”, a prova prática visa testar as habilidades de programação e desenvolvimento e, além disso, conhecer o estilo de trabalho do candidato a trainee do Biopark. Assim, solicita a construção do primeiro ‘sprint’ de um sistema de gestão acadêmica. Portanto, determina os seguintes termos:

## 2 - REQUISITOS MÍNIMOS

* A primeira sprint consiste no desenvolvimento de dois endpoints. O primeiro endpoint para registro do aluno e o segundo endpoint para consulta do aluno. Os endpoints devem ter no mínimo os seguintes campos: nome; CPF; data de nascimento;
* Linguagens: preferência por Java, Python ou JavaScript, mas pode ser qualquer outra condicionado a explicação do motivo da escolha;
* Banco de dados: utilizar MySql ou PostgreSql;
* Banco de dados e tabelas: a criação do banco e das tabelas fica a critério do candidato, seja via script ou aplicação;
* APIs: devem seguir o modelo Restfull com formato Json;
* Seguir as boas práticas de programação.
* Envio: o desafio deve ser enviado preferencialmente como repositório Git público (Github, Gitlab ou Bitbucket), com commits pequenos e bem descritos. Ou enviado como arquivo compactado (Zip ou Tar);
* O repositório deve estar com modelo de licença de código aberto.

## 3 - TECNOLOGIAS

* Linguagem de programação: Java;
* Framework: Spring (Boot, Web, Data Jpa, Validation, Cache e DevTools);
* Banco de Dados: H2 em desenvolvimento e PostgreSql em produção;
* IDE e outras ferramentas: NetBeans, Maven, Postman, Swagger/OpenAPI e GitHub;

### Motivação por Java:
* Java é uma linguagem de programação e uma plataforma de desenvolvimento de software. O qual permite desenvolver software para desktop, mobile, web e para diversos eletrônicos (televisões, eletrodomésticos, cartões bancários e naves espaciais);
* Portabilidade - rodam em qualquer sistema operacional e em qualquer hardware;
* Tipagem Estática - fornece maior segurança ao código;
* Multi-threaded - capacidade de suportar processamentos múltiplos;
* Gratuidade - linguagem e ambientes de produção gratuitos;
* Internacionalização - suporta nativamente caracteres Unicode;
* Multiparadigma;
* Vasta biblioteca de rotinas e APIs
* A máquina virtual Java roda diversas outras linguagens;
* Mercado amplo e aquecido;
* Variedade de frameworks;
* Comunidade atuante na confecção de materiais de estudo, palestras, eventos e cursos;

## 4 - ENDPOINTS

### Verbos e Endpoints

* GET - /alunos/v1/consultar
* GET - /alunos/v1/consultar/{id}
* POST - /alunos/v1/cadastrar
* PUT - /alunos/v1/atualizar/{id}
* DELETE - /alunos/v1/deletar/{id}






