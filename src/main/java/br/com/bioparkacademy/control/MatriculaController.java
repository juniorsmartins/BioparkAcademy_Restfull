package br.com.bioparkacademy.control;

import br.com.bioparkacademy.control.dto.CursoDtoOut;
import br.com.bioparkacademy.control.dto.MatriculaDtoOut;
import br.com.bioparkacademy.model.Curso;
import br.com.bioparkacademy.model.Matricula;
import br.com.bioparkacademy.repository.CursoRepository;
import br.com.bioparkacademy.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JuniorMartins
 */
@RestController
@RequestMapping("/matriculas/v1")
public class MatriculaController 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Autowired
    private MatriculaRepository matriculaRepository;
    
    // -------------------- MÉTODOS CONTROLADORES -------------------- //
    // ----- CONSULTAR -----
    @GetMapping("/consultar")
    @Cacheable(value = "consultarMatriculas")
    public Page<MatriculaDtoOut> consultarMatriculas(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, 
            page = 0, size = 5) Pageable paginacao)
    {
        Page<Matricula> matriculas = matriculaRepository.findAll(paginacao);
        return MatriculaDtoOut.converter(matriculas);
    }
}
