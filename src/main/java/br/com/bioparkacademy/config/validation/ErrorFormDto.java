package br.com.bioparkacademy.config.validation;

/**
 * @author JuniorMartins
 */
public class ErrorFormDto 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    private String campo;
    private String erro;

    // -------------------- CONSTRUTORES -------------------- //
    public ErrorFormDto(String campo, String erro) 
    {
        this.campo = campo;
        this.erro = erro;
    }
    
    // -------------------- MÉTODOS DE ACESSO -------------------- //
    public String getCampo() 
    {return campo;}
    public String getErro() 
    {return erro;}
    
    
}
