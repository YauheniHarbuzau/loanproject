package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.PersonDto;
import by.itstep.loanproject.dto.PersonDtoWithId;
import by.itstep.loanproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RestController
@RequestMapping("/itstep")
@Tag(name = "Person manager", description = "Search, save and delete persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    @Operation(summary = "Get persons", description = "Get all persons")
    public List<PersonDtoWithId> findAll() {
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    @Operation(summary = "Get person", description = "Get person by ID")
    public PersonDtoWithId findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping("/persons")
    @Operation(summary = "Save", description = "Save person")
    public void save(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }

    @DeleteMapping("/persons/{id}")
    @Operation(summary = "Delete", description = "Delete person by ID")
    public void deleteById(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }
}