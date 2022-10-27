package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Loan;
import lombok.Data;

/**
 * DTO for the {@link Loan} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see LoanDto
 */
@Data
public class LoanDtoWithId extends LoanDto {

    private Long id;
}