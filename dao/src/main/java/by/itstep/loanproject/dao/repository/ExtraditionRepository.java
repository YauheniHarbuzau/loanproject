package by.itstep.loanproject.dao.repository;

import by.itstep.loanproject.dao.entity.Extradition;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the {@link Extradition}
 *
 * @author Yauheni Harbuzau
 */
@Repository
public interface ExtraditionRepository extends JpaRepository<Extradition, Long> {

    @EntityGraph(attributePaths = {"person", "loan"})
    List<Extradition> findAll();

    Optional<Extradition> findById(Long id);
}