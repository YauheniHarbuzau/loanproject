package by.itstep.loanproject.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Entity for the Person
 *
 * @author Yauheni Harbuzau
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID

    @Column(name = "name")
    private String name; // Имя

    @Column(name = "last_name")
    private String lastName; // Фамилия

    @Column(name = "birth_date")
    private LocalDate birthDate; // Дата рождения

    @Column(name = "year_income")
    private Double yearIncome; // Годовой доход

    @Column(name = "passport")
    private String passport; // Паспортные данные
}