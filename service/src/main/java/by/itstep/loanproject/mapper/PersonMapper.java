package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Person;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.mapper.uses.DateTimeMapper;
import org.mapstruct.Mapper;

/**
 * Mapper for the {@link Person} and {@link PersonDto}
 *
 * @author Yauheni Harbuzau
 */
@Mapper(componentModel = "spring", uses = {DateTimeMapper.class})
public interface PersonMapper {

    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);
}