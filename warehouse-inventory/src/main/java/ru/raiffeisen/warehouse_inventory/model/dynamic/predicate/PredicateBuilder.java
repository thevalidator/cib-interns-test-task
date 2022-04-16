/*
 * The Krechet Software
 */
package ru.raiffeisen.warehouse_inventory.model.dynamic.predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import ru.raiffeisen.warehouse_inventory.model.dynamic.SearchCriteria;
import ru.raiffeisen.warehouse_inventory.model.dynamic.SearchOperator;

/**
 *
 * @author theValidator <the.validator@yandex.ru>
 */
public interface PredicateBuilder {
    
    SearchOperator getOperator();
    
    Predicate getPredicate(CriteriaBuilder cb, Path path, SearchCriteria criteria);
    
}
