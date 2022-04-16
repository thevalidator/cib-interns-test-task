/*
 * The Krechet Software
 */
package ru.raiffeisen.warehouse_inventory.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.warehouse_inventory.Socks;

/**
 *
 * @author theValidator <the.validator@yandex.ru>
 */
@Repository
public interface SocksRepository extends JpaRepository<Socks, Long>, JpaSpecificationExecutor<Socks> {

//    @Query(value = "select s.* from socks s "
//            + "where s.color = ? and s.cotton_percent < ?", nativeQuery = true)
//    public List<Socks> findAllByColorAndCottonLessThan(String color, Integer cottonPart);
//    
//    @Query(value = "select s.* from socks s "
//            + "where s.color = ? and s.cotton_percent > ?", nativeQuery = true)
//    public List<Socks> findAllByColorAndCottonMoreThan(String color, Integer cottonPart);
//    
//    @Query(value = "select s.* from socks s "
//            + "where s.color = ? and s.cotton_percent = ?", nativeQuery = true)
//    public List<Socks> findAllByColorAndCottonEquals(String color, Integer cottonPart);
    
    //public List<Socks> findAllByCriteria(String criteria);
    
    
}
