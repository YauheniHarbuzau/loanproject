package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Extradition;
import by.itstep.loanproject.dto.ExtraditionDto;
import org.springframework.stereotype.Component;

/**
 * Mapper for the {@link Extradition} and {@link ExtraditionDto}
 *
 * @author Yauheni Harbuzau
 * @see PersonMapper
 * @see LoanMapper
 */
@Component
public class ExtraditionMapper {

    private PersonMapper personMapper;
    private LoanMapper loanMapper;

    public ExtraditionMapper(PersonMapper personMapper, LoanMapper loanMapper) {
        this.personMapper = personMapper;
        this.loanMapper = loanMapper;
    }

    public Extradition extraditionDtoToExtradition(ExtraditionDto extraditionDto) {
        if (extraditionDto == null) {
            return null;
        }
        Extradition extradition = new Extradition();
        extradition.setId(extraditionDto.getId());
        extradition.setPerson(personMapper.personDtoToPerson(extraditionDto.getPersonDto()));
        extradition.setLoan(loanMapper.loanDtoToLoan(extraditionDto.getLoanDto()));
        extradition.setIssueDate(extraditionDto.getIssueDate());
        return extradition;
    }

    public ExtraditionDto extraditionToExtraditionDto(Extradition extradition) {
        if (extradition == null) {
            return null;
        }
        ExtraditionDto extraditionDto = new ExtraditionDto();
        extraditionDto.setId(extradition.getId());
        extraditionDto.setPersonDto(personMapper.personToPersonDto(extradition.getPerson()));
        extraditionDto.setLoanDto(loanMapper.loanToLoanDto(extradition.getLoan()));
        extraditionDto.setIssueDate(extradition.getIssueDate());
        return extraditionDto;
    }
}