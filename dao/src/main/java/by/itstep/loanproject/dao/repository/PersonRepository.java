package by.itstep.loanproject.dao.repository;

import by.itstep.loanproject.dao.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the {@link Person}
 *
 * @author Yauheni Harbuzau
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @EntityGraph(attributePaths = {"passport"})
    List<Person> findAll();

    Optional<Person> findById(Long id);
}