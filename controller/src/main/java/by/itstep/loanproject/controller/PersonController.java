package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for the {@link PersonService}
 *
 * @author Yauheni Harbuzau
 */
@RestController
@RequestMapping("/itstep")
@Tag(name = "Менеджер клиентов", description = "Для поиска, сохранения и удаления клиентов")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/findAll")
    @Operation(summary = "Все клиенты", description = "Получение всех клиентов")
    List<PersonDto> findAll() {
        return personService.findAll();
    }

    @GetMapping("/person/findById/{id}")
    @Operation(summary = "Один клиента", description = "Получение одного клиента по ID")
    PersonDto findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping("/person/save")
    @Operation(summary = "Сохранение", description = "Сохранение одного клиента")
    void save(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }

    @DeleteMapping("/person/deleteById/{id}")
    @Operation(summary = "Удаление", description = "Удаление одного клиента по ID")
    void deleteById(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }
}