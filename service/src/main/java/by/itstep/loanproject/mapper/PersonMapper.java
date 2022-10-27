package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Person;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.dto.PersonDtoWithId;
import by.itstep.loanproject.mapper.uses.DateTimeMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the {@link Person}, {@link PersonDto} and {@link PersonDtoWithId}
 *
 * @author Yauheni Harbuzau
 */
@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface PersonMapper {

    Person toPerson(PersonDto personDto);

    Person toPerson(PersonDtoWithId personDtoWithId);

    PersonDto toPersonDto(Person person);

    PersonDtoWithId toPersonDtoWithId(Person person);
}