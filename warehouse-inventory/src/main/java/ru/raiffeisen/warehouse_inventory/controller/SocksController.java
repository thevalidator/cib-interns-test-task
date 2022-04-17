/*
 * The Krechet Software
 */
package ru.raiffeisen.warehouse_inventory.controller;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.warehouse_inventory.Color;
import ru.raiffeisen.warehouse_inventory.Socks;
import ru.raiffeisen.warehouse_inventory.model.dynamic.SearchOperator;
import ru.raiffeisen.warehouse_inventory.model.dynamic.SearchBuilder;
import ru.raiffeisen.warehouse_inventory.model.dynamic.SearchCriteria;
import ru.raiffeisen.warehouse_inventory.model.repository.SocksRepository;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
@RestController
@Validated
public class SocksController {

    @Autowired
    private SocksRepository socksRepository;
    private SearchBuilder<Socks> builder = new SearchBuilder<>();

    @GetMapping("/api/socks")
    public List<Socks> getTasks(@RequestParam(value = "color") String col,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "cottonPart") @Min(0) @Max(100) Integer cottonPart) {

        Color color = Color.valueOf(col.trim().toUpperCase());

        SearchCriteria criteria = new SearchCriteria("cottonPercent", SearchOperator.findOperator(operation), cottonPart);

        return socksRepository.findAll(builder.buildSpecification(criteria));
    }

    @PostMapping("/api/socks/income")
    public ResponseEntity socksIncome(@RequestParam(value = "color") String col,
            @RequestParam(value = "cottonPart") @Min(0) @Max(100) Integer cottonPart,
            @RequestParam(value = "quantity") @Min(0) Integer quantity) {

        Color color = Color.valueOf(col.trim().toUpperCase());
        Socks s = new Socks(cottonPart, color, quantity);
        socksRepository.saveAndFlush(s);

        return new ResponseEntity(s.getId(), HttpStatus.OK);
    }

    @PostMapping("/api/socks/outcome")
    public ResponseEntity socksOutcome(@RequestParam(value = "color") String col,
            @RequestParam(value = "cottonPart") @Min(0) @Max(100) Integer cottonPart,
            @RequestParam(value = "quantity") @Min(0) Integer quantity) {
        
        Socks s = socksRepository.findByColorAndCottonPart(col.trim().toUpperCase(), cottonPart).orElseThrow();
        s.setQuantity(quantity);
        socksRepository.saveAndFlush(s);

        return new ResponseEntity(s.getId(), HttpStatus.OK);
    }

}
