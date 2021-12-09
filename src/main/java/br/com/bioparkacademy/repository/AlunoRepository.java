package br.com.bioparkacademy.repository;

import br.com.bioparkacademy.model.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JuniorMartins
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
    public List<Aluno> findByDataNascimento(String dataNascimento);
}





