package fr.sg.configuration;

import fr.sg.account.service.DefaultAccountService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAccountService.class);

    @Before(value="execution(* fr.sg.account.*.*(..))", argNames = "joinPoint")
    public void doBeforeAnyCall(JoinPoint joinPoint) {
        LOGGER.debug("Entering method :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
    }

    @After("execution(* fr.sg.account.*.*(..))")
    public void doAfterAnyCall(JoinPoint joinPoint) {
        LOGGER.debug("Exiting method :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
    }

}
