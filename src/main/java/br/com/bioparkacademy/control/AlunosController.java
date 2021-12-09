package br.com.bioparkacademy.control;

import br.com.bioparkacademy.control.dto.AlunoDtoOut;
import br.com.bioparkacademy.control.dto.AlunoDtoIn;
import br.com.bioparkacademy.model.Aluno;
import br.com.bioparkacademy.repository.AlunoRepository;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author JuniorMartins
 */
@RestController // Anotação para informar ao Spring que é uma API Rest (suprime necessidade de @ResponseBody nos métodos)
@RequestMapping("/alunos/v1") 
public class AlunosController 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Autowired
    private AlunoRepository alunoRepository;

    // -------------------- MÉTODOS CONTROLADORES -------------------- //
    @GetMapping("/consultar")
    public List<AlunoDtoOut> consultarAlunos(String dataNascimento)
    {
        if(dataNascimento != null)
            return AlunoDtoOut.converter(alunoRepository.findByDataNascimento(dataNascimento)); // busca seletiva
        return AlunoDtoOut.converter(alunoRepository.findAll()); // buscar todos
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoDtoOut> cadastrarAlunos(@RequestBody @Valid AlunoDtoIn alunoDtoIn, 
            UriComponentsBuilder uriComponentsBuilder)
    {
        var aluno = alunoDtoIn.converter();
        alunoRepository.saveAndFlush(aluno);
        
        URI uri = uriComponentsBuilder.path("/alunos/v1/consultar/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDtoOut(aluno)); 
    }
    
    
}
