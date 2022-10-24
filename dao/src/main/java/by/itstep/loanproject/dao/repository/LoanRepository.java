package by.itstep.loanproject.dao.repository;

import by.itstep.loanproject.dao.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the {@link Loan}
 *
 * @author Yauheni Harbuzau
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findById(Long id);
}