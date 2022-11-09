package by.itstep.loanproject.mapper;

import by.itstep.loanproject.dao.entity.Passport;
import by.itstep.loanproject.dto.PassportDto;
import by.itstep.loanproject.dto.PassportDtoWithId;
import org.mapstruct.Mapper;

/**
 * Mapper for the {@link Passport}, {@link PassportDto} and {@link PassportDtoWithId}
 *
 * @author Yauheni Harbuzau
 */
@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport toPassport(PassportDto passportDto);

    PassportDtoWithId toPassportDtoWithId(Passport passport);
}