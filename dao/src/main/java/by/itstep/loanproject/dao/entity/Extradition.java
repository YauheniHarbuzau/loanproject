package by.itstep.loanproject.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Entity for the Extradition
 *
 * @author Yauheni Harbuzau
 * @see Person
 * @see Loan
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "extradition")
public class Extradition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    private Loan loan;

    @Column(name = "issue_date")
    private LocalDate issueDate;
}