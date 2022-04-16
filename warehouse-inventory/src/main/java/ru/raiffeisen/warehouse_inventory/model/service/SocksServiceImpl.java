/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.warehouse_inventory.Socks;
import ru.raiffeisen.warehouse_inventory.model.repository.SocksRepository;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
@Service
@Transactional
public class SocksServiceImpl implements SocksService {
    
    @Autowired
    private final SocksRepository socksRepository;

    public SocksServiceImpl(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

//    @Override
//    public List<Socks> getSocks(String color, String operation, Integer cottonPart) {
//        
//        List<Socks> result = socksRepository.findAllByColorAndCottonLessThan(color, cottonPart);
//        
//        return result;
//    }
    
    

}
