package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Person;
import by.itstep.loanproject.dao.repository.PersonRepository;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.dto.PersonDtoWithId;
import by.itstep.loanproject.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for the {@link Person}, {@link PersonDto} and {@link PersonDtoWithId}
 *
 * @author Yauheni Harbuzau
 */
@AllArgsConstructor
@Service
@Scope("singleton")
public class PersonService implements AbstractService<Person> {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    /**
     * Method for finding all Persons
     *
     * @return List<PersonDto>
     */
    public List<PersonDtoWithId> findAll() {
        return personRepository.findAll().stream().map(personMapper::toPersonDtoWithId).collect(Collectors.toList());
    }

    /**
     * Method for finding single Person by ID
     *
     * @param id for Person
     * @return PersonDto
     */
    public PersonDtoWithId findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.toPersonDtoWithId(person);
    }

    /**
     * Method for saving single Person
     *
     * @param personDto PersonDto
     */
    public void save(PersonDto personDto) {
        personRepository.save(personMapper.toPerson(personDto));
    }

    /**
     * Method for deleting single Person by ID
     *
     * @param id for Person
     */
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}