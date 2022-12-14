package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.ExtraditionDtoWithId;
import by.itstep.loanproject.service.ExtraditionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller for the {@link ExtraditionService}
 *
 * @author Yauheni Harbuzau
 */
@AllArgsConstructor
@RestController
@RequestMapping("/itstep")
@Tag(name = "Extradition manager", description = "Search, save and delete extraditions")
public class ExtraditionController {

    private final ExtraditionService extraditionService;

    @GetMapping("/extraditions")
    @Operation(summary = "Get extraditions", description = "Get all extraditions")
    public List<ExtraditionDtoWithId> findAll() {
        return extraditionService.findAll();
    }

    @GetMapping("/extraditions/{id}")
    @Operation(summary = "Get extradition", description = "Get extradition by ID")
    public ExtraditionDtoWithId findById(@PathVariable("id") Long id) {
        return extraditionService.findById(id);
    }

    @PostMapping("/extraditions")
    @Operation(summary = "Save", description = "Save extradition")
    public void save(@RequestBody ExtraditionDto extraditionDto) {
        extraditionService.save(extraditionDto);
    }

    @PostMapping("/extraditions/saveWithParam")
    @Operation(summary = "Save", description = "Save extradition")
    public void saveWithParam(@RequestParam Long personId, @RequestParam Long loanId, @RequestParam LocalDate issueDate) {
        extraditionService.saveWithParam(personId, loanId, issueDate);
    }

    @DeleteMapping("/extraditions/{id}")
    @Operation(summary = "Delete", description = "Delete extradition by ID")
    public void deleteById(@PathVariable("id") Long id) {
        extraditionService.deleteById(id);
    }

    @GetMapping("/extraditions/{id}/isGiveLoan")
    @Operation(summary = "If a loan can be given", description = "Comparison between person annual income and loan sum by extradition ID")
    public boolean isGiveLoan(@PathVariable("id") Long id) {
        return extraditionService.isGiveLoan(id);
    }

    @GetMapping("/extraditions/{id}/getMonthlyPayment")
    @Operation(summary = "Get monthly payment", description = "Get monthly payment by extradition ID")
    public double getMonthlyPayment(@PathVariable("id") Long id) {
        return extraditionService.getMonthlyPayment(id);
    }

    @GetMapping("/extraditions/{id}/getFullPayment")
    @Operation(summary = "Get full payment", description = "Get full payment by extradition ID")
    public double getFullPayment(@PathVariable("id") Long id) {
        return extraditionService.getFullPayment(id);
    }

    @GetMapping("/extraditions/getRemainingPayment")
    @Operation(summary = "Get remaining payment", description = "Get remaining payment by extradition ID and by number of months paid")
    public double getRemainingPayment(@RequestParam Long id, @RequestParam Short monthsPaid) {
        return extraditionService.getRemainingPayment(id, monthsPaid);
    }
}