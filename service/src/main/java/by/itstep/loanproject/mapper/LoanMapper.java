package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Loan;
import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.dto.LoanDtoWithId;
import org.mapstruct.Mapper;

/**
 * Mapper for the {@link Loan}, {@link LoanDto} and {@link LoanDtoWithId}
 *
 * @author Yauheni Harbuzau
 */
@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan toLoan(LoanDto loanDto);

    LoanDtoWithId toLoanDtoWithId(Loan loan);
}