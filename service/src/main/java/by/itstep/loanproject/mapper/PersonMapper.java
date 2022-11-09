package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Person;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.dto.PersonDtoWithId;
import by.itstep.loanproject.mapper.uses.DateTimeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the {@link Person}, {@link PersonDto} and {@link PersonDtoWithId}
 *
 * @author Yauheni Harbuzau
 * @see DateTimeMapper
 * @see PassportMapper
 */
@Mapper(componentModel = "spring", uses = {DateTimeMapper.class, PassportMapper.class})
public interface PersonMapper {

    @Mapping(target = "passport", source = "passportDto")
    Person toPerson(PersonDto personDto);

    @Mapping(target = "passportDtoWithId", source = "passport")
    PersonDtoWithId toPersonDtoWithId(Person person);
}