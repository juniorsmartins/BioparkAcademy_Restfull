package br.com.bioparkacademy.control.dto;

import br.com.bioparkacademy.model.Matricula;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;

/**
 * @author JuniorMartins
 */
public class MatriculaDtoOut 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private Long id;
    private String numMatricula;
    private LocalDateTime dataMatricula;
    
    // -------------------- CONSTRUTORES -------------------- //
    public MatriculaDtoOut(Matricula matricula)
    {
        id = matricula.getId();
        numMatricula = matricula.getNumMatricula();
        dataMatricula = matricula.getDataMatricula();
    }
    
    // -------------------- MÉTODOS AUXILIARES -------------------- //
    public static Page<MatriculaDtoOut> converter(Page<Matricula> matriculas)
    {return matriculas.map(MatriculaDtoOut::new);}
    
    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public Long getId() 
    {return id;}
    public String getNumMatricula() 
    {return numMatricula;}
    public void setNumMatricula(String numMatricula) 
    {this.numMatricula = numMatricula;}
    public LocalDateTime getDataMatricula() 
    {return dataMatricula;}
    public void setDataMatricula(LocalDateTime dataMatricula) 
    {this.dataMatricula = dataMatricula;}
   
}





