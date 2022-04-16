/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public class SocksController {
    
    @Autowired
    private SocksRepository socksRepository;
    private SearchBuilder<Socks> builder = new SearchBuilder<>();
    
//    @GetMapping("/api/socks")
//    public List<Socks> getSocks() {
//        
//        List<Socks> result = socksRepository.findAll();
//                
//        return result;
//    }
    
    @GetMapping("/api/socks")
    public List<Socks> getTasks(@RequestParam(value = "color") String col,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "cottonPart") Integer cottonPart) {
        
        //List<Socks> result = socksRepository.findAllByColorAndCottonLessThan(color, percent);
        Color color = Color.valueOf(col.trim().toUpperCase());
        if (cottonPart > 100 || cottonPart < 0) {
            throw new IllegalArgumentException("cotton part value is not valid");
        }
        SearchCriteria criteria = new SearchCriteria("cottonPercent", SearchOperator.findOperator(operation), cottonPart);
        
        
                
        return socksRepository.findAll(builder.buildSpecification(criteria));
    }
    
    @PostMapping("/api/socks")
    public long addSocks(@RequestParam(value = "color") String col,
            @RequestParam(value = "cottonPart") Integer cottonPart) {
        
        Color color = Color.valueOf(col.trim().toUpperCase());
        if (cottonPart > 100 || cottonPart < 0) {
            throw new IllegalArgumentException("cotton part value is not valid");
        }
        Socks s = new Socks(cottonPart, color);
        socksRepository.saveAndFlush(s);
        
        
        return s.getId();
        
    }
    
    @PostMapping("/api/socks/income")
    public long addSocksIncome(@RequestParam(value = "color") String col, 
            @RequestParam(value = "cottonPart") Integer cottonPart, 
            @RequestParam(value = "quantity") Integer quantity) {
        
        Color color = Color.valueOf(col.trim().toUpperCase());
        if (cottonPart > 100 || cottonPart < 0 || quantity < 0) {
            throw new IllegalArgumentException("cotton part value is not valid");
        }
        Socks s = new Socks(cottonPart, color, quantity);
        socksRepository.saveAndFlush(s);
        
        
        return s.getId();
    }

}
