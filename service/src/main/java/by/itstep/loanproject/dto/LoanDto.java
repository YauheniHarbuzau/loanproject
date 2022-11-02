package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Loan;
import by.itstep.loanproject.dao.entity.LoanPurpose;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for the {@link Loan} entity
 *
 * @author Yauheni Harbuzau
 */
@Data
public class LoanDto implements Serializable {

    private String name;
    private LoanPurpose loanPurpose;
    private Double interestRate;
    private Double maxSum;
    private Integer termInMonths;
}