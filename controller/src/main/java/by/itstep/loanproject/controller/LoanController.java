package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.dto.LoanDtoWithId;
import by.itstep.loanproject.service.LoanService;
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
 * Controller for the {@link LoanService}
 *
 * @author Yauheni Harbuzau
 */
@AllArgsConstructor
@RestController
@RequestMapping("/itstep")
@Tag(name = "Loan manager", description = "Search, save and delete loans")
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/loans")
    @Operation(summary = "Get loans", description = "Get all loans")
    public List<LoanDtoWithId> findAll() {
        return loanService.findAll();
    }

    @GetMapping("/loans/{id}")
    @Operation(summary = "Get loan", description = "Get loan by ID")
    public LoanDtoWithId findById(@PathVariable("id") Long id) {
        return loanService.findById(id);
    }

    @PostMapping("/loans")
    @Operation(summary = "Save", description = "Save loan")
    public void save(@RequestBody LoanDto loanDto) {
        loanService.save(loanDto);
    }

    @DeleteMapping("/loans/{id}")
    @Operation(summary = "Delete", description = "Delete loan by ID")
    public void deleteById(@PathVariable("id") Long id) {
        loanService.deleteById(id);
    }
}