package by.itstep.loanproject.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Getting ID for the {@link PersonAspect}, {@link LoanAspect}, {@link ExtraditionAspect}
 *
 * @author Yauheni Harbuzau
 */
public class IdForAspect {

    protected static Long getId(JoinPoint joinPoint, String signatureName) {
        Long id = null;
        if (joinPoint.getSignature().getName().equals(signatureName)) {
            Object[] arguments = joinPoint.getArgs();
            for (Object args : arguments) {
                if (args instanceof Long) {
                    id = (Long) args;
                }
            }
        }
        return id;
    }
}