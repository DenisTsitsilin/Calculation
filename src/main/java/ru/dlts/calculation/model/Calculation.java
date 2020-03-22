package ru.dlts.calculation.model;

import lombok.Data;

@Data
public class Calculation {
    private Integer id;
    /**
     * Процент
     */
    private Double percent;
    /**
     * Стоимость имущества
     */
    private Double costImmovable;
    /**
     * Первоначальный взнос
     */
    private Double initialFee;
    /**
     * Срок кредита
     */
    private Double creditTerm;
}
