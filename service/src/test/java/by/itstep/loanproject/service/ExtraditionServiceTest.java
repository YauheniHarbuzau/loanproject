package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Extradition;
import by.itstep.loanproject.dao.repository.ExtraditionRepository;
import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.mapper.ExtraditionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Test for the {@link ExtraditionService}
 *
 * @author Yauheni Harbuzau
 */
@ExtendWith(MockitoExtension.class)
class ExtraditionServiceTest {

    @Mock
    private ExtraditionRepository extraditionRepository;

    @Mock
    private ExtraditionMapper extraditionMapper;

    @InjectMocks
    private ExtraditionService extraditionService;

    private static PersonDto personDto = new PersonDto();
    private static LoanDto loanDto = new LoanDto();
    private static Extradition extradition = new Extradition();
    private static ExtraditionDto extraditionDto = new ExtraditionDto();

    @BeforeEach
    public void setup() {

        personDto.setId(1L);
        personDto.setYearIncome(2001.0);

        loanDto.setId(1L);
        loanDto.setInterestRate(12.0);
        loanDto.setMaxSum(2000.0);
        loanDto.setTermInMonths(12);

        extraditionDto.setId(1L);
        extraditionDto.setPersonDto(personDto);
        extraditionDto.setLoanDto(loanDto);

        when(extraditionMapper.extraditionToExtraditionDto(extradition)).thenReturn(extraditionDto);
        when(extraditionRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(extradition));
    }

    @Test
    @DisplayName("Test isGiveLoan method")
    public void isGiveLoanTest() {
        assertTrue(extraditionService.isGiveLoan(1L));
    }

    @Test
    @DisplayName("Test getMonthlyPayment method")
    public void getMonthlyPaymentTest() {
        assertEquals(166.71, extraditionService.getMonthlyPayment(1L));
        assertNotEquals(166.70, extraditionService.getMonthlyPayment(1L));
        assertNotEquals(166.72, extraditionService.getMonthlyPayment(1L));
    }

    @Test
    @DisplayName("Test getFullPayment method")
    public void getFullPaymentTest() {
        assertEquals(2000.52, extraditionService.getFullPayment(1L));
        assertNotEquals(2000.51, extraditionService.getFullPayment(1L));
        assertNotEquals(2000.53, extraditionService.getFullPayment(1L));
    }
}