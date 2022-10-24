package by.itstep.loanproject.dao.entity;

/**
 * Purpose type for the {@link Loan}
 *
 * @author Yauheni Harbuzau
 */
public enum LoanPurpose {

    CONSUMER("CONSUMER"), // Потребительский
    CAR_LOAN("CAR_LOAN"), // Автокредит
    MORTGAGE("MORTGAGE"); // Ипотека

    private final String type;

    LoanPurpose(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}