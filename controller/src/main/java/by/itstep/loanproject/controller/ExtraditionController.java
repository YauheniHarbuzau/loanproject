package by.itstep.loanproject.controller;

import by.itstep.loanproject.dto.ExtraditionDto;
import by.itstep.loanproject.dto.ExtraditionDtoWithId;
import by.itstep.loanproject.service.ExtraditionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RestController
@RequestMapping("/itstep")
@Tag(
        name = "Оформление кредитных соглашений",
        description = "Для оформления кредитных соглашений, поиска и обработки выданных кредитов"
)
public class ExtraditionController {

    private ExtraditionService extraditionService;

    public ExtraditionController(ExtraditionService extraditionService) {
        this.extraditionService = extraditionService;
    }

    @GetMapping("/extradition/findAll")
    @Operation(summary = "Все кредитные соглашения", description = "Получение всех кредитных соглашений")
    List<ExtraditionDtoWithId> findAll() {
        return extraditionService.findAll();
    }

    @GetMapping("/extradition/findById/{id}")
    @Operation(summary = "Одно кредитное соглашение", description = "Получение одного кредитного соглашения по ID")
    ExtraditionDtoWithId findById(@PathVariable("id") Long id) {
        return extraditionService.findById(id);
    }

    @PostMapping("/extradition/save")
    @Operation(summary = "Сохранение", description = "Сохранение одного кредитного соглашения")
    void save(@RequestBody ExtraditionDto extraditionDto) {
        extraditionService.save(extraditionDto);
    }

    @PostMapping("/extradition/saveWithParam")
    @Operation(summary = "Сохранение", description = "Сохранение одного кредитного соглашения")
    void saveWithParam(@RequestParam Long personId, @RequestParam Long loanId, @RequestParam LocalDate issueDate) {
        extraditionService.saveWithParam(personId, loanId, issueDate);
    }

    @DeleteMapping("/extradition/deleteById/{id}")
    @Operation(summary = "Удаление", description = "Удаление одного кредитного соглашения по ID")
    void deleteById(@PathVariable("id") Long id) {
        extraditionService.deleteById(id);
    }

    @GetMapping("/extradition/isGiveLoan/{id}")
    @Operation(summary = "Можно ли выдать кредит", description = "Проверка больше ли годовой доход клиента суммы кредита")
    boolean isGiveLoan(@PathVariable("id") Long id) {
        return extraditionService.isGiveLoan(id);
    }

    @GetMapping("/extradition/getMonthlyPayment/{id}")
    @Operation(summary = "Месячный платёж", description = "Получение суммы месячного платежа по ID кредитного соглашения")
    double getMonthlyPayment(@PathVariable("id") Long id) {
        return extraditionService.getMonthlyPayment(id);
    }

    @GetMapping("/extradition/getFullPayment/{id}")
    @Operation(summary = "Полная сумма платежа", description = "Получение полной суммы платежа по ID кредитного соглашения")
    double getFullPayment(@PathVariable("id") Long id) {
        return extraditionService.getFullPayment(id);
    }
}