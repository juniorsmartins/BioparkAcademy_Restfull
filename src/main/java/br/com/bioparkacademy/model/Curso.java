package br.com.bioparkacademy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JuniorMartins
 */
@Entity
@Table(name = "cursos")
public class Curso implements Serializable
{
    // -------------------- ATRIBUTOS DE CLASSE -------------------- //
    public static final long serialVersionUID = 1l;
    
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private int cargaHoraria;
    @Column
    private double preco;
    
    // -------------------- CONSTRUTORES -------------------- //
    public Curso(){}
    public Curso(String nome, int cargaHoraria, double preco) 
    {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preco = preco;
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
    public int getCargaHoraria() 
    {return cargaHoraria;}
    public void setCargaHoraria(int cargaHoraria) 
    {this.cargaHoraria = cargaHoraria;}
    public double getPreco() 
    {return preco;}
    public void setPreco(double preco) 
    {this.preco = preco;}
    

}






