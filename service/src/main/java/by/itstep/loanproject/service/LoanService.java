package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Loan;
import by.itstep.loanproject.dao.repository.LoanRepository;
import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.dto.LoanDtoWithId;
import by.itstep.loanproject.mapper.LoanMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for the {@link Loan}, {@link LoanDto} and {@link LoanDtoWithId}
 *
 * @author Yauheni Harbuzau
 */
@AllArgsConstructor
@Service
@Scope("singleton")
public class LoanService implements AbstractService<Loan> {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    /**
     * Method for finding all Loans
     *
     * @return List<LoanDto>
     */
    public List<LoanDtoWithId> findAll() {
        return loanRepository.findAll().stream().map(loanMapper::toLoanDtoWithId).collect(Collectors.toList());
    }

    /**
     * Method for finding single Loan by ID
     *
     * @param id for Loan
     * @return LoanDto
     */
    public LoanDtoWithId findById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return loanMapper.toLoanDtoWithId(loan);
    }

    /**
     * Method for saving single Loan
     *
     * @param loanDto LoanDto
     */
    public void save(LoanDto loanDto) {
        loanRepository.save(loanMapper.toLoan(loanDto));
    }

    /**
     * Method for deleting single Loan by ID
     *
     * @param id for Loan
     */
    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}