package by.itstep.loanproject.dto;

import by.itstep.loanproject.dao.entity.Passport;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for the {@link Passport} entity
 *
 * @author Yauheni Harbuzau
 */
@Data
public class PassportDto implements Serializable {

    private String series;
    private String number;
}