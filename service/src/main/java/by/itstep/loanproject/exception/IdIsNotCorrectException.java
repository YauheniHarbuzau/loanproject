package by.itstep.loanproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for the incorrect ID or non-existent ID
 *
 * @author Yauheni Harbuzau
 */
@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
@Getter
public class IdIsNotCorrectException extends RuntimeException {

    public IdIsNotCorrectException() {
        this("ID is not correct or ID is not found");
    }

    public IdIsNotCorrectException(String message) {
        super(message);
    }
}