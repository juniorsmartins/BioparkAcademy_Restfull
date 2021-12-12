package br.com.bioparkacademy.repository;

import br.com.bioparkacademy.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JuniorMartins
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>
{}




