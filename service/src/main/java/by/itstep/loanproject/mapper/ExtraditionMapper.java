package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Extradition;
import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.ExtraditionDtoWithId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the {@link Extradition}, {@link ExtraditionDto} and {@link ExtraditionDtoWithId}
 *
 * @author Yauheni Harbuzau
 * @see PersonMapper
 * @see LoanMapper
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, LoanMapper.class})
public interface ExtraditionMapper {

    @Mapping(target = "person", source = "personDto")
    @Mapping(target = "loan", source = "loanDto")
    Extradition toExtradition(ExtraditionDto extraditionDto);

    @Mapping(target = "personDtoWithId", source = "person")
    @Mapping(target = "loanDtoWithId", source = "loan")
    ExtraditionDtoWithId toExtraditionDtoWithId(Extradition extradition);
}