package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Extradition;
import by.itstep.loanproject.dao.repository.ExtraditionRepository;
import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.ExtraditionDtoWithId;
import by.itstep.loanproject.mapper.ExtraditionMapper;
import org.decimal4j.util.DoubleRounder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for the {@link Extradition}, {@link ExtraditionDto} and {@link ExtraditionDtoWithId}
 *
 * @author Yauheni Harbuzau
 * @see PersonService
 * @see LoanService
 */
@Service
@Scope("singleton")
public class ExtraditionService implements AbstractService<Extradition> {

    private ExtraditionRepository extraditionRepository;
    private PersonService personService;
    private LoanService loanService;
    private ExtraditionMapper extraditionMapper;

    public ExtraditionService(
            ExtraditionRepository extraditionRepository,
            PersonService personService,
            LoanService loanService,
            ExtraditionMapper extraditionMapper
    ) {
        this.extraditionRepository = extraditionRepository;
        this.personService = personService;
        this.loanService = loanService;
        this.extraditionMapper = extraditionMapper;
    }

    /**
     * Method for finding all Extraditions
     *
     * @return List<ExtraditionDto>
     */
    public List<ExtraditionDtoWithId> findAll() {
        return extraditionRepository.findAll().stream()
                .map(extradition -> extraditionMapper.toExtraditionDtoWithId(extradition))
                .collect(Collectors.toList());
    }

    /**
     * Method for finding single Extradition by ID
     *
     * @param id for Extradition
     * @return ExtraditionDto
     */
    public ExtraditionDtoWithId findById(Long id) {
        Extradition extradition = extraditionRepository.findById(id).orElseThrow();
        return extraditionMapper.toExtraditionDtoWithId(extradition);
    }

    /**
     * Method for saving single Extradition
     *
     * @param extraditionDto ExtraditionDto
     */
    public void save(ExtraditionDto extraditionDto) {
        extraditionRepository.save(extraditionMapper.toExtradition(extraditionDto));
    }

    /**
     * Method for saving single Extradition by Person ID and Loan ID
     *
     * @param personId  for Person
     * @param loanId    for Loan
     * @param issueDate date of Extradition, object of class LocalDate
     */
    public void saveWithParam(Long personId, Long loanId, LocalDate issueDate) {
        ExtraditionDto extraditionDto = new ExtraditionDto();
        extraditionDto.setPersonDto(personService.findById(personId));
        extraditionDto.setLoanDto(loanService.findById(loanId));
        extraditionDto.setIssueDate(issueDate);
        extraditionRepository.save(extraditionMapper.toExtradition(extraditionDto));
    }

    /**
     * Method for deleting single Extradition by ID
     *
     * @param id for Extradition
     */
    public void deleteById(Long id) {
        extraditionRepository.deleteById(id);
    }

    /**
     * Method for comparing YearIncome from Person and MaxSum from Loan
     *
     * @param id for Extradition
     * @return boolean true if YearIncome more than MaxSum
     */
    public boolean isGiveLoan(Long id) {
        ExtraditionDtoWithId extraditionDtoWithId = findById(id);
        return extraditionDtoWithId.getPersonDtoWithId().getYearIncome() / 12 >
                extraditionDtoWithId.getLoanDtoWithId().getMaxSum() /
                        extraditionDtoWithId.getLoanDtoWithId().getTermInMonths();
    }

    /**
     * Method for calculation monthly payment
     *
     * @param id for Extradition
     * @return monthly payment
     */
    public double getMonthlyPayment(Long id) {
        ExtraditionDtoWithId extraditionDtoWithId = findById(id);
        double maxSum = extraditionDtoWithId.getLoanDtoWithId().getMaxSum();
        double interestRate = extraditionDtoWithId.getLoanDtoWithId().getInterestRate();
        int termInMonths = extraditionDtoWithId.getLoanDtoWithId().getTermInMonths();
        double monthlyRate = interestRate / 12; // Ставка по кредиту в месяц
        double annuityRatio = // Коэффициент аннуитета
                (Math.pow(1 + monthlyRate, termInMonths) * monthlyRate) /
                        (Math.pow(1 + monthlyRate, termInMonths) - 1);
        return DoubleRounder.round(maxSum / termInMonths * annuityRatio, 2);
    }

    /**
     * Method for calculation full payment
     *
     * @param id for Extradition
     * @return full payment
     */
    public double getFullPayment(Long id) {
        ExtraditionDtoWithId extraditionDtoWithId = findById(id);
        return getMonthlyPayment(id) * extraditionDtoWithId.getLoanDtoWithId().getTermInMonths();
    }
}