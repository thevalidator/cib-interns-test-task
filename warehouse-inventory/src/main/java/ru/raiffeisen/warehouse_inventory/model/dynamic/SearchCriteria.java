/*
 * The Krechet Software
 */

package ru.raiffeisen.warehouse_inventory.model.dynamic;

/**
 * @author theValidator <the.validator@yandex.ru>
 */
public class SearchCriteria {
    
    private String key;
    private SearchOperator operator;
    private Integer value;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, SearchOperator operator, Integer value) {
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SearchOperator getOperator() {
        return operator;
    }

    public void setOperator(SearchOperator operator) {
        this.operator = operator;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    

}
