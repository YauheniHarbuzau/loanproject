package by.itstep.loanproject.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for the Loan
 *
 * @author Yauheni Harbuzau
 * @see LoanPurpose
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loan")
public class Loan {

    /**
     * Fields, RU: ID, Наименование, Цель кредита, Процентная ставка, Максимальная сумма, Срок в месяцах
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "purpose")
    @Enumerated(EnumType.STRING)
    private LoanPurpose loanPurpose;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "max_sum")
    private Double maxSum;

    @Column(name = "term_in_months")
    private Integer termInMonths;
}