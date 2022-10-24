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

    private Long id; // ID
    private String name; // Название
    private LoanPurpose loanPurpose; // Цель кредита
    private Double interestRate; // Процентная ставка
    private Double maxSum; // Максимальная сумма
    private Integer termInMonths; // Срок в месяцах
}