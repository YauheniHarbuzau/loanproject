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

    private Long id; // ID
    private String name; // Имя
    private String lastName; // Фамилия
    private LocalDate birthDate; // Дата рождения
    private Double yearIncome; // Годовой доход
    private String passport; // Паспортные данные
}