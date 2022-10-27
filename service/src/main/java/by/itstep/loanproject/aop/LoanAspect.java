package by.itstep.loanproject.aop;

import by.itstep.loanproject.dao.repository.LoanRepository;
import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.exception.EntityIsNotCorrectException;
import by.itstep.loanproject.exception.IdIsNotCorrectException;
import by.itstep.loanproject.service.LoanService;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * AOP for the {@link LoanService}
 *
 * @author Yauheni Harbuzau
 */
@Component
@Aspect
public class LoanAspect {

    private LoanRepository loanRepository;

    public LoanAspect(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Before("execution(* by.itstep.loanproject.service.LoanService.findAll(..))")
    public void beforeFindAllMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        logger.info("Получение всех кредитов");
    }

    @Before("execution(* by.itstep.loanproject.service.LoanService.findById(..))")
    public void beforeFindByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "findById");
        logger.info("Получение кредита по ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.LoanService.save(..))")
    public void beforeSaveMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        LoanDto loanDto = getLoanDto(joinPoint, "save");
        logger.info("Сохранение кредита с наименованием: {}", loanDto.getName());
        if (!isLoanDtoCorrect(loanDto)) {
            logger.error("Entity is not correct");
            throw new EntityIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.LoanService.deleteById(..))")
    public void beforeDeleteByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "deleteById");
        logger.info("Удаление кредита по ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    //--------------------------------------------------------------------------------------------------------------

    private LoanDto getLoanDto(JoinPoint joinPoint, String signatureName) {
        LoanDto loanDto = null;
        if (joinPoint.getSignature().getName().equals(signatureName)) {
            Object[] arguments = joinPoint.getArgs();
            for (Object args : arguments) {
                if (args instanceof LoanDto) {
                    loanDto = (LoanDto) args;
                }
            }
        }
        return loanDto;
    }

    private boolean isLoanDtoCorrect(LoanDto loanDto) {
        return loanDto.getName().length() >= 1 &&
                loanDto.getLoanPurpose() != null &&
                loanDto.getInterestRate() != 0 &&
                loanDto.getMaxSum() != 0 &&
                loanDto.getTermInMonths() != 0;
    }

    private boolean isIdCorrect(Long id) {
        return id != 0 &&
                loanRepository.findAll().stream().anyMatch(loan -> loan.getId().equals(id));
    }
}