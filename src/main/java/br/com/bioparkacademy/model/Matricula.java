package br.com.bioparkacademy.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author JuniorMartins
 */
@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1l;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String numMatricula;
    @Column
    private LocalDateTime dataMatricula;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    // -------------------- CONSTRUTORES -------------------- //
    public Matricula(){}
    public Matricula(Curso curso, Aluno aluno)
    {
        this.curso = curso;
        this.aluno = aluno;
        dataMatricula = LocalDateTime.now();
        numMatricula = LocalDate.now() + "-" + curso.getId() + "-" + aluno.getId();
    }  
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public Long getId() 
    {return id;}
    public String getNumMatricula() 
    {return numMatricula;}
    public LocalDateTime getDataMatricula() 
    {return dataMatricula;}
    public void setDataMatricula(LocalDateTime dataMatricula) 
    {this.dataMatricula = dataMatricula;}
    public Curso getCurso() 
    {return curso;}
    public void setCurso(Curso curso) 
    {this.curso = curso;}
    public Aluno getAluno() 
    {return aluno;}
    public void setAluno(Aluno aluno) 
    {this.aluno = aluno;}
    
    
    
    
}
