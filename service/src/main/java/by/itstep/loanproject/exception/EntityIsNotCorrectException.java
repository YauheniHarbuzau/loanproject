package by.itstep.loanproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for the incorrect Entity
 *
 * @author Yauheni Harbuzau
 */
@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
@Getter
public class EntityIsNotCorrectException extends RuntimeException {

    public EntityIsNotCorrectException() {
        this("Entity is not correct");
    }

    public EntityIsNotCorrectException(String message) {
        super(message);
    }
}