package br.com.bioparkacademy.control.dto;

import br.com.bioparkacademy.model.Curso;
import org.springframework.data.domain.Page;

/**
 * @author JuniorMartins
 */
public class CursoDtoOut 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private Long id;
    private String nome;
    private int cargaHoraria;
    
    // -------------------- CONSTRUTORES -------------------- //
    public CursoDtoOut(Curso curso)
    {
        id = curso.getId();
        nome = curso.getNome();
        cargaHoraria = curso.getCargaHoraria();
    }
    
    // -------------------- MÉTODOS AUXILIARES -------------------- //
    public static Page<CursoDtoOut> converter(Page<Curso> cursos)
    {return cursos.map(CursoDtoOut::new);}
    
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
    
    
    
    
    
}
