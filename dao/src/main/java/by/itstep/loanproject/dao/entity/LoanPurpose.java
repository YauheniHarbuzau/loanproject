package by.itstep.loanproject.dao.entity;

/**
 * Purpose type for the {@link Loan}
 *
 * @author Yauheni Harbuzau
 */
public enum LoanPurpose {

    /**
     * Purpose type, RU: Потребительский, Автокредит, Ипотека
     */
    CONSUMER("CONSUMER"),
    CAR_LOAN("CAR_LOAN"),
    MORTGAGE("MORTGAGE");

    private final String type;

    LoanPurpose(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}