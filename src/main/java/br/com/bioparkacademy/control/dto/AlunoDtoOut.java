package br.com.bioparkacademy.control.dto;

import br.com.bioparkacademy.model.Aluno;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;

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
    private LocalDateTime dataCadastro;
 
    // -------------------- CONSTRUTORES -------------------- //
    public AlunoDtoOut(Aluno aluno)
    {   // De fato, a conversao de Aluno em AlunoDto ocorre aqui no construtor
        id = aluno.getId();
        nome = aluno.getNome();
        cpf = aluno.getCpf();
        dataNascimento = aluno.getDataNascimento();
        dataCadastro = aluno.getDataCadastro();
    }
    
    // -------------------- MÉTODOS AUXILIARES -------------------- //
    public static Page<AlunoDtoOut> converter(Page<Aluno> alunos)
    {return alunos.map(AlunoDtoOut::new);}

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
    public Long getId() 
    {return id;}
    public String getNome() 
    {return nome;}
    public String getCpf() 
    {return cpf;}
    public String getDataNascimento() 
    {return dataNascimento;}
    public LocalDateTime getDataCadastro()
    {return dataCadastro;}
    public void setId(Long id) 
    {this.id = id;}
    public void setNome(String nome) 
    {this.nome = nome;}
    public void setCpf(String cpf) 
    {this.cpf = cpf;}
    public void setDataNascimento(String dataNascimento) 
    {this.dataNascimento = dataNascimento;}
    public void setDataCadastro(LocalDateTime dataCadastro) 
    {this.dataCadastro = dataCadastro;}
     
}







