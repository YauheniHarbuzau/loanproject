package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Person;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for the {@link Person} entity
 *
 * @author Yauheni Harbuzau
 */
@Data
public class PersonDto implements Serializable {

    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Double yearIncome;
    private String passport;
}