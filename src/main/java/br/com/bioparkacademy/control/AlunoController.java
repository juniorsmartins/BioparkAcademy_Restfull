package br.com.bioparkacademy.control;

import br.com.bioparkacademy.control.dto.AlunoDtoOut;
import br.com.bioparkacademy.control.dto.AlunoDtoIn;
import br.com.bioparkacademy.model.Aluno;
import br.com.bioparkacademy.repository.AlunoRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author JuniorMartins
 */
@RestController // Anotação para informar ao Spring que é uma API Rest (suprime necessidade de @ResponseBody nos métodos)
@RequestMapping("/alunos/v1") 
public class AlunoController 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Autowired
    private AlunoRepository alunoRepository;

    // -------------------- MÉTODOS CONTROLADORES -------------------- //
    // ----- CONSULTAR -----
    @GetMapping("/consultar")
    public List<AlunoDtoOut> consultarAlunos(String dataNascimento)
    {
        if(dataNascimento != null)
            return AlunoDtoOut.converter(alunoRepository.findByDataNascimento(dataNascimento)); // busca seletiva
        return AlunoDtoOut.converter(alunoRepository.findAll()); // buscar todos
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<AlunoDtoOut> consultarPorId(@PathVariable Long id)
    {
        var aluno = alunoRepository.findById(id);
        
        if(!aluno.isPresent())
        {return ResponseEntity.notFound().build();}
        
        return ResponseEntity.ok(new AlunoDtoOut(aluno.get()));
    }
    
    // ----- CADASTRAR -----
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<AlunoDtoOut> cadastrarAluno(@RequestBody @Valid AlunoDtoIn alunoDtoIn, 
            UriComponentsBuilder uriComponentsBuilder)
    {
        var aluno = alunoDtoIn.converter();
        alunoRepository.saveAndFlush(aluno);
        
        URI uri = uriComponentsBuilder.path("/alunos/v1/consultar/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDtoOut(aluno)); 
    }
    
    // ----- ATUALIZAR -----
    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<AlunoDtoOut> atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoDtoIn alunoDtoIn)
    {
        var aluno = alunoRepository.findById(id);
        
        if(!aluno.isPresent())
        {return ResponseEntity.notFound().build();}
        
        return ResponseEntity.ok(new AlunoDtoOut(alunoDtoIn.atualizar(aluno.get())));
    }
    
    // ----- DELETAR -----
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> removerAluno(@PathVariable Long id)
    {
        if(!alunoRepository.existsById(id))
        {return ResponseEntity.notFound().build();}
        
        alunoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
