package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.LoanDto;
import by.itstep.loanproject.service.LoanService;
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
 * Controller for the {@link LoanService}
 *
 * @author Yauheni Harbuzau
 */
@RestController
@RequestMapping("/itstep")
@Tag(name = "Менеджер кредитов", description = "Для поиска, сохранения и удаления кредитов")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan/findAll")
    @Operation(summary = "Все кредиты", description = "Получение всех кредитов")
    List<LoanDto> findAll() {
        return loanService.findAll();
    }

    @GetMapping("/loan/findById/{id}")
    @Operation(summary = "Один кредит", description = "Получение одного кредита по ID")
    LoanDto findById(@PathVariable("id") Long id) {
        return loanService.findById(id);
    }

    @PostMapping("/loan/save")
    @Operation(summary = "Сохранение", description = "Сохранение одного кредита")
    void save(@RequestBody LoanDto loanDto) {
        loanService.save(loanDto);
    }

    @DeleteMapping("/loan/deleteById/{id}")
    @Operation(summary = "Удаление", description = "Удаление одного кредита по ID")
    void deleteById(@PathVariable("id") Long id) {
        loanService.deleteById(id);
    }
}