/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory.model.dynamic;

import ru.raiffeisen.warehouse_inventory.model.dynamic.predicate.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
public class SearchBuilder<T> {
    
    private Map<String, Join<Object, Object>> joinMap = new HashMap();
    
    private Map<SearchOperator, PredicateBuilder> possiblePredicateBuiders = Stream.of(
            new AbstractMap.SimpleEntry<SearchOperator, PredicateBuilder>(SearchOperator.EQUAL, new EqPredicateBuilder()),
            new AbstractMap.SimpleEntry<SearchOperator, PredicateBuilder>(SearchOperator.LESS_THAN, new LessThanPredicateBuilder()),
            new AbstractMap.SimpleEntry<SearchOperator, PredicateBuilder>(SearchOperator.MORE_THAN, new MoreThanPredicateBuilder())
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    
    public Specification<T> buildSpecification(SearchCriteria criteria) {
        this.joinMap.clear();
        return (root, query, cb) -> buildPredicate(root, cb, criteria);
    }

    private Predicate buildPredicate(Root<T> root, CriteriaBuilder cb, SearchCriteria criteria) {
        
        return possiblePredicateBuiders.get(criteria.getOperator())
                .getPredicate(cb, buildPath(root, criteria.getKey()), criteria);
    }

    private Path buildPath(Root<T> root, String key) {
        
        return root.get(key);
        
    }

}
