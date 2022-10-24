package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Loan;
import by.itstep.loanproject.dao.repository.LoanRepository;
import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.mapper.LoanMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for the {@link Loan} and {@link LoanDto}
 *
 * @author Yauheni Harbuzau
 */
@Service
@Scope("singleton")
public class LoanService implements AbstractService<Loan> {

    private LoanRepository loanRepository;
    private LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    /**
     * Method for finding all Loans
     *
     * @return List<LoanDto>
     */
    public List<LoanDto> findAll() {
        return loanRepository.findAll().stream()
                .map(loan -> loanMapper.loanToLoanDto(loan))
                .collect(Collectors.toList());
    }

    /**
     * Method for finding single Loan by ID
     *
     * @param id for Loan
     * @return LoanDto
     */
    public LoanDto findById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return loanMapper.loanToLoanDto(loan);
    }

    /**
     * Method for saving single Loan
     *
     * @param loanDto LoanDto
     */
    public void save(LoanDto loanDto) {
        loanRepository.save(loanMapper.loanDtoToLoan(loanDto));
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