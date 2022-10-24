package by.itstep.loanproject.service;

import by.itstep.loanproject.dao.entity.Person;
import by.itstep.loanproject.dao.repository.PersonRepository;
import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.mapper.PersonMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for the {@link Person} and {@link PersonDto}
 *
 * @author Yauheni Harbuzau
 */
@Service
@Scope("singleton")
public class PersonService implements AbstractService<Person> {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    /**
     * Method for finding all Persons
     *
     * @return List<PersonDto>
     */
    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(person -> personMapper.personToPersonDto(person))
                .collect(Collectors.toList());
    }

    /**
     * Method for finding single Person by ID
     *
     * @param id for Person
     * @return PersonDto
     */
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.personToPersonDto(person);
    }

    /**
     * Method for saving single Person
     *
     * @param personDto PersonDto
     */
    public void save(PersonDto personDto) {
        personRepository.save(personMapper.personDtoToPerson(personDto));
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