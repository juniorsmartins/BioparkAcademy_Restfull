package br.com.bioparkacademy.control.dto;

import br.com.bioparkacademy.model.Aluno;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

/**
 * @author JuniorMartins
 */
public class AlunoDtoIn 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @NotNull @NotEmpty @Size(min = 3, max = 150)
    private String nome;
    @CPF
    private String cpf;
    @NotNull @NotEmpty @Size(max = 10)
    private String dataNascimento;
    
    // -------------------- MÉTODOS AUXILIARES -------------------- //
    public Aluno converter()
    {return new Aluno(nome, cpf, dataNascimento);}
    
    public Aluno atualizar(Aluno aluno)
    {
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        return aluno;
    }

    // -------------------- MÉTODOS DE ACESSO E MODIFICAÇÃO -------------------- //
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
    
}



