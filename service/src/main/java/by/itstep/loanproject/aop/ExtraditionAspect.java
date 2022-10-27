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
        logger.info("Получение всех кредитных соглашений");
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.findById(..))")
    public void beforeFindByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "findById");
        logger.info("Получение кредитного соглашения по ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.save(..))")
    public void beforeSaveMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        ExtraditionDto extraditionDto = getExtraditionDto(joinPoint, "save");
        logger.info(
                "Сохранение кредитного соглашения для клиента: {} {}, кредит: {}",
                extraditionDto.getPersonDto().getName(),
                extraditionDto.getPersonDto().getLastName(),
                extraditionDto.getLoanDto().getName()
        );
        if (!isExtraditionDtoCorrect(extraditionDto)) {
            logger.error("Entity is not correct");
            throw new EntityIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.saveWithParam(..))")
    public void beforeSaveWithParamMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        logger.info("Сохранение кредитного соглашения по заданным ID клиента и ID кредита");
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.deleteById(..))")
    public void beforeDeleteByIdMethod(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "deleteById");
        logger.info("Удаление кредитного соглашения по ID: {}", id);
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.isGiveLoan(..))")
    public void beforeIsGiveLoan(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "isGiveLoan");
        logger.info(
                "Проверка больше ли годовой доход клиента суммы кредита по ID кредитного соглашения: {}",
                id
        );
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.getMonthlyPayment(..))")
    public void beforeGetMonthlyPayment(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "getMonthlyPayment");
        logger.info(
                "Получение суммы месячного платежа по ID кредитного соглашения: {}",
                id
        );
        if (!isIdCorrect(id)) {
            logger.error("ID is not correct or ID is not found");
            throw new IdIsNotCorrectException();
        }
    }

    @Before("execution(* by.itstep.loanproject.service.ExtraditionService.getFullPayment(..))")
    public void beforeGetFullPayment(JoinPoint joinPoint) {
        Logger logger = getLogger(joinPoint.getTarget().getClass());
        Long id = IdForAspect.getId(joinPoint, "getFullPayment");
        logger.info(
                "Получение полной суммы платежа по ID кредитного соглашения: {}",
                id
        );
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
        return extraditionDto.getPersonDto() != null &&
                extraditionDto.getLoanDto() != null &&
                extraditionDto.getIssueDate() != null;
    }

    private boolean isIdCorrect(Long id) {
        return id != 0 &&
                extraditionRepository.findAll().stream().anyMatch(extradition -> extradition.getId().equals(id));
    }
}