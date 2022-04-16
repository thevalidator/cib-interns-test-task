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
 * @author theValidator <the.validator@yandex.ru>
 */
public class MoreThanPredicateBuilder implements PredicateBuilder {

    @Override
    public SearchOperator getOperator() {
        return SearchOperator.MORE_THAN;
    }

    @Override
    public Predicate getPredicate(CriteriaBuilder cb, Path path, SearchCriteria criteria) {
        if (criteria.getValue() == null) {
            return cb.isNull(path);
        }
        return cb.greaterThan(path, criteria.getValue());
    }
    
    

}
