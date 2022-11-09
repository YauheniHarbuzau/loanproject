package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Person;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO for the {@link Person} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see PassportDtoWithId
 */
@Data
@JsonPropertyOrder({"id", "name", "lastName", "birthDate", "yearIncome", "passportDtoWithId"})
public class PersonDtoWithId extends PersonDto {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Double yearIncome;
    private PassportDtoWithId passportDtoWithId;
}