package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Extradition;
import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.ExtraditionDtoWithId;
import org.springframework.stereotype.Component;

/**
 * Mapper for the {@link Extradition}, {@link ExtraditionDto} and {@link ExtraditionDtoWithId}
 *
 * @author Yauheni Harbuzau
 * @see PersonMapper
 * @see LoanMapper
 */
@Component
public class ExtraditionMapper {

    private final PersonMapper personMapper;
    private final LoanMapper loanMapper;

    public ExtraditionMapper(PersonMapper personMapper, LoanMapper loanMapper) {
        this.personMapper = personMapper;
        this.loanMapper = loanMapper;
    }

    public Extradition toExtradition(ExtraditionDto extraditionDto) {
        if (extraditionDto == null) {
            return null;
        }
        Extradition extradition = new Extradition();
        extradition.setPerson(personMapper.toPerson(extraditionDto.getPersonDto()));
        extradition.setLoan(loanMapper.toLoan(extraditionDto.getLoanDto()));
        extradition.setIssueDate(extraditionDto.getIssueDate());
        return extradition;
    }

    public ExtraditionDtoWithId toExtraditionDtoWithId(Extradition extradition) {
        if (extradition == null) {
            return null;
        }
        ExtraditionDtoWithId extraditionDtoWithId = new ExtraditionDtoWithId();
        extraditionDtoWithId.setId(extradition.getId());
        extraditionDtoWithId.setPersonDtoWithId(personMapper.toPersonDtoWithId(extradition.getPerson()));
        extraditionDtoWithId.setLoanDtoWithId(loanMapper.toLoanDtoWithId(extradition.getLoan()));
        extraditionDtoWithId.setIssueDate(extradition.getIssueDate());
        return extraditionDtoWithId;
    }
}