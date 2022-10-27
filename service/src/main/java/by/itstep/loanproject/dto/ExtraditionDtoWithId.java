package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Extradition;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for the {@link Extradition} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see PersonDtoWithId
 * @see LoanDtoWithId
 */
@Data
public class ExtraditionDtoWithId implements Serializable {

    private Long id;
    private PersonDtoWithId personDtoWithId;
    private LoanDtoWithId loanDtoWithId;
    private LocalDate issueDate;
}