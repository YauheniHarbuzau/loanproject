package by.itstep.loanproject.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity for the Person
 *
 * @author Yauheni Harbuzau
 * @see Passport
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport; // Паспортные данные
}