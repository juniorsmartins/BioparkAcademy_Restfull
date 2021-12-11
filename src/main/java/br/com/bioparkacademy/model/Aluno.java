package br.com.bioparkacademy.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JuniorMartins
 */
@Entity
@Table(name = "alunos")
public class Aluno implements Serializable
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1l;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String dataNascimento;
    @Column
    private LocalDateTime dataCadastro = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula = StatusMatricula.NAO_MATRICULADO;
    
    // -------------------- CONSTRUTORES -------------------- //
    public Aluno(){}
    public Aluno(String nome, String cpf, String dataNascimento) 
    {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public Long getId() 
    {return id;}
    public void setId(Long id) 
    {this.id = id;}
    public String getNome() 
    {return nome;}
    public void setNome(String nome) 
    {this.nome = nome;}
    public String getCpf() 
    {return cpf;}
    public void setCpf(String cpf) 
    {this.cpf = cpf;}
    public String getDataNascimento() 
    {return dataNascimento;}
    public void setDataNascimento(String dataNascimento) 
    {this.dataNascimento = dataNascimento;}
    public LocalDateTime getDataCadastro() 
    {return dataCadastro;}
    public void setDataCadastro(LocalDateTime dataCadastro) 
    {this.dataCadastro = dataCadastro;}
    public StatusMatricula getStatusMatricula() 
    {return statusMatricula;}
    public void setStatusMatricula(StatusMatricula statusMatricula) 
    {this.statusMatricula = statusMatricula;}
    
    
    
}


