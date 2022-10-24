package by.itstep.loanproject.mapper.exeption;

import by.itstep.loanproject.mapper.uses.DateTimeMapper;

/**
 * Exception for the {@link DateTimeMapper}
 *
 * @author Yauheni Harbuzau
 */
public class DateTimeMapperException extends RuntimeException {

    public DateTimeMapperException() {
        this("Incorrect datetime source string");
    }

    public DateTimeMapperException(String message) {
        super(message);
    }
}