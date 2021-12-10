package br.com.bioparkacademy.repository;

import br.com.bioparkacademy.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JuniorMartins
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
    public Page<Aluno> findByDataNascimento(String dataNascimento, Pageable paginacao);
}





