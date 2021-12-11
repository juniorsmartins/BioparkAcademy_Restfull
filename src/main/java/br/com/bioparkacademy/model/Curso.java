package br.com.bioparkacademy.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "curso")
    private List<Matricula> listaMatriculas;
    
    // -------------------- CONSTRUTORES -------------------- //
    public Curso(){}
    public Curso(String nome, int cargaHoraria) 
    {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
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
    public List<Matricula> getListaMatriculas() 
    {return listaMatriculas;}
    public void setListaMatriculas(List<Matricula> listaMatriculas) 
    {this.listaMatriculas = listaMatriculas;}
    
    
    
    

}






