/*
 * The Krechet Software
 */
package ru.raiffeisen.warehouse_inventory.model.dynamic;

/**
 *
 * @author theValidator <the.validator@yandex.ru>
 */
public enum SearchOperator {
    
    LESS_THAN("lessThan"),
    MORE_THAN("moreThan"),
    EQUAL("equal");
    
    private final String command;

    private SearchOperator(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
    
    public static SearchOperator findOperator(String s) {
        for (SearchOperator operator: SearchOperator.values()) {
            if (operator.getCommand().equals(s)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("No such operator found!");
    }
    
    
}
