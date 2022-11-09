package by.itstep.loanproject.aop;

import by.itstep.loanproject.dao.repository.PersonRepository;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.exception.EntityIsNotCorrectException;
import by.itstep.loanproject.exception.IdIsNotCorrectException;
import by.itstep.loanproject.service.PersonService;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * AOP for the {@link PersonService}
 *
 * @author Yauheni Harbuzau
 */
@Component
@Aspect
public class PersonAspect {

    private final PersonRepository personRepository;

    public PersonAspect(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Before("execution(* by.itstep.loanproject.service.PersonService.findAll(..))")
    public void beforeFindAllMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        logger.info("Get all persons");
    }

    @Before("execution(* by.itstep.loanproject.service.PersonService.findById(..))")
    public void beforeFindByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "findById");
        logger.info("Get person by ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.PersonService.save(..))")
    public void beforeSaveMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        PersonDto personDto = getPersonDto(joinPoint, "save");
        logger.info("Save person: {}", personDto);
        if (!isPersonDtoCorrect(personDto)) {
            logger.error("Entity is not correct");
            throw new EntityIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.PersonService.deleteById(..))")
    public void beforeDeleteByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "deleteById");
        logger.info("Delete person by ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    //--------------------------------------------------------------------------------------------------------------

    private PersonDto getPersonDto(JoinPoint joinPoint, String signatureName) {
        PersonDto personDto = null;
        if (joinPoint.getSignature().getName().equals(signatureName)) {
            Object[] arguments = joinPoint.getArgs();
            for (Object args : arguments) {
                if (args instanceof PersonDto) {
                    personDto = (PersonDto) args;
                }
            }
        }
        return personDto;
    }

    protected static boolean isPersonDtoCorrect(PersonDto personDto) {
        return personDto.getName().length() >= 1 &&
                personDto.getLastName().length() >= 1 &&
                personDto.getBirthDate() != null &&
                personDto.getYearIncome() != 0 &&
                personDto.getPassportDto().getSeries().length() == 2 &&
                personDto.getPassportDto().getNumber().length() == 7;
    }

    private boolean isIdCorrect(Long id) {
        return id != 0 && personRepository.findAll().stream().anyMatch(person -> person.getId().equals(id));
    }
}