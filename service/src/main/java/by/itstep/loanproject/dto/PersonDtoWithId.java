package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Person;
import lombok.Data;

/**
 * DTO for the {@link Person} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see PersonDto
 */
@Data
public class PersonDtoWithId extends PersonDto {

    private Long id;
}