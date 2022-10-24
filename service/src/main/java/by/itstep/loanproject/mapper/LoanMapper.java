package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Loan;
import by.itstep.loanproject.dto.LoanDto;
import org.mapstruct.Mapper;

/**
 * Mapper for the {@link Loan} and {@link LoanDto}
 *
 * @author Yauheni Harbuzau
 */
@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan loanDtoToLoan(LoanDto loanDto);

    LoanDto loanToLoanDto(Loan loan);
}