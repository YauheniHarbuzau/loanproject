package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Passport;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * DTO for the {@link Passport} entity with ID
 *
 * @author Yauheni Harbuzau
 * @see PassportDto
 */
@Data
@JsonPropertyOrder({"id", "series", "number"})
public class PassportDtoWithId extends PassportDto {

    private Long id;
}