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

/**
 * Entity for the Passport
 *
 * @author Yauheni Harbuzau
 * @see Person
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passport")
public class Passport {

    /**
     * Fields, RU: ID, Серия, Номер
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;
}