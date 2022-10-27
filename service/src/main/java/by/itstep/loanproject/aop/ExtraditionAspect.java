package by.itstep.loanproject.aop;

import by.itstep.loanproject.dao.repository.ExtraditionRepository;
import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.exception.EntityIsNotCorrectException;
import by.itstep.loanproject.exception.IdIsNotCorrectException;
import by.itstep.loanproject.service.ExtraditionService;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * AOP for the {@link ExtraditionService}
 *
 * @author Yauheni Harbuzau
 */
@Component
@Aspect
public class ExtraditionAspect {

    private ExtraditionRepository extraditionRepository;

    public ExtraditionAspect(ExtraditionRepository extraditionRepository) {
        this.extraditionRepository = extraditionRepository;
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.findAll(..))")
    public void beforeFindAllMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        logger.info("Get all extraditions");
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.findById(..))")
    public void beforeFindByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "findById");
        logger.info("Get extradition by ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.save(..))")
    public void beforeSaveMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        ExtraditionDto extraditionDto = getExtraditionDto(joinPoint, "save");
        logger.info("Save extradition: {}", extraditionDto);
        if (!isExtraditionDtoCorrect(extraditionDto)) {
            logger.error("Entity is not correct");
            throw new EntityIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.saveWithParam(..))")
    public void beforeSaveWithParamMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        logger.info("Save extradition by person ID and by loan ID");
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.deleteById(..))")
    public void beforeDeleteByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "deleteById");
        logger.info("Delete extradition by ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.isGiveLoan(..))")
    public void beforeIsGiveLoan(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "isGiveLoan");
        logger.info("Comparison between person annual income and loan sum by extradition ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.getMonthlyPayment(..))")
    public void beforeGetMonthlyPayment(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "getMonthlyPayment");
        logger.info("Get monthly payment by extradition ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.getFullPayment(..))")
    public void beforeGetFullPayment(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "getFullPayment");
        logger.info("Get full payment by extradition ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    //--------------------------------------------------------------------------------------------------------------

    private ExtraditionDto getExtraditionDto(JoinPoint joinPoint, String signatureName) {
        ExtraditionDto extraditionDto = null;
        if (joinPoint.getSignature().getName().equals(signatureName)) {
            Object[] arguments = joinPoint.getArgs();
            for (Object args : arguments) {
                if (args instanceof ExtraditionDto) {
                    extraditionDto = (ExtraditionDto) args;
                }
            }
        }
        return extraditionDto;
    }

    private boolean isExtraditionDtoCorrect(ExtraditionDto extraditionDto) {
        return PersonAspect.isPersonDtoCorrect(extraditionDto.getPersonDto()) &&
                LoanAspect.isLoanDtoCorrect(extraditionDto.getLoanDto()) &&
                extraditionDto.getIssueDate() != null;
    }

    private boolean isIdCorrect(Long id) {
        return id != 0 &&
                extraditionRepository.findAll().stream().anyMatch(extradition -> extradition.getId().equals(id));
    }
}