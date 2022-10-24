package by.itstep.loanproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Loan Project - Application entry point
 *
 * @author Yauheni Harbuzau
 */
@SpringBootApplication(scanBasePackages = "by.itstep.*")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}