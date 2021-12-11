package br.com.bioparkacademy.control;

import br.com.bioparkacademy.control.dto.CursoDtoOut;
import br.com.bioparkacademy.model.Curso;
import br.com.bioparkacademy.repository.CursoRepository;
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
@RequestMapping("/cursos/v1")
public class CursoController 
{
    // -------------------- ATRIBUTOS DE INSTÂNCIA -------------------- //
    @Autowired
    private CursoRepository cursoRepository;
    
    // -------------------- MÉTODOS CONTROLADORES -------------------- //
    // ----- CONSULTAR -----
    @GetMapping("/consultar")
    @Cacheable(value = "consultarCursos")
    public Page<CursoDtoOut> consultarCursos(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, 
            page = 0, size = 5) Pageable paginacao)
    {
        Page<Curso> cursos = cursoRepository.findAll(paginacao);
        return CursoDtoOut.converter(cursos);
    }

    
}
