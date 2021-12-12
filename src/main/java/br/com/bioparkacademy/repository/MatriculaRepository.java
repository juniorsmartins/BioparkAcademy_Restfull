package br.com.bioparkacademy.repository;

import br.com.bioparkacademy.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JuniorMartins
 */
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>
{}





