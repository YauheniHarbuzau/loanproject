package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Extradition;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for the {@link Extradition} entity
 *
 * @author Yauheni Harbuzau
 * @see PersonDto
 * @see LoanDto
 */
@Data
public class ExtraditionDto implements Serializable {

    private Long id;
    private PersonDto personDto;
    private LoanDto loanDto;
    private LocalDate issueDate;
}