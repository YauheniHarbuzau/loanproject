package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Loan;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * DTO for the {@link Loan} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see LoanDto
 */
@Data
@JsonPropertyOrder({"id", "name", "loanPurpose", "interestRate", "maxSum", "termInMonth"})
public class LoanDtoWithId extends LoanDto {

    private Long id;
}