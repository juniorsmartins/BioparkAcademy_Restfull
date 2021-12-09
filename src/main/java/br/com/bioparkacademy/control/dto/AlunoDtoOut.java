package br.com.bioparkacademy.control.dto;

import br.com.bioparkacademy.model.Aluno;
import br.com.bioparkacademy.model.StatusMatricula;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JuniorMartins
 */
public class AlunoDtoOut 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private StatusMatricula statusMatricula;

    // -------------------- CONSTRUTORES -------------------- //
    public AlunoDtoOut(Aluno aluno)
    {   // De fato, a conversao de Aluno em AlunoDto ocorre aqui no construtor. O método converter apenas instancia e coleta
        id = aluno.getId();
        nome = aluno.getNome();
        cpf = aluno.getCpf();
        dataNascimento = aluno.getDataNascimento();
        statusMatricula = aluno.getStatusMatricula();
    }
    
    // -------------------- MÉTODOS AUXILIARES -------------------- //
    public static List<AlunoDtoOut> converter(List<Aluno> alunos)
    {return alunos.stream().map(AlunoDtoOut::new).collect(Collectors.toList());} // Funcional/STREAM para converter Aluno em AlunoDto
    
    // -------------------- MÉTODOS DE ACESSO -------------------- //
    public Long getId()
    {return id;}
    public String getNome() 
    {return nome;}
    public String getCpf() 
    {return cpf;}
    public String getDataNascimento() 
    {return dataNascimento;}
    public StatusMatricula getStatusMatricula() 
    {return statusMatricula;}

    
    

    
}







