/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.miage.unitconverter;

import java.math.BigDecimal;

/**
 *
 * @author MORIN
 */
public class Unit {
    
    private String name;
    private BigDecimal coef;
    private BigDecimal decalage;
    private boolean reference;

    public Unit(String name, BigDecimal coef, Boolean reference) {
        this.name = name.toUpperCase();
        this.coef = coef;
        this.decalage = BigDecimal.ZERO;
        this.reference = reference;
    }
    
    public Unit(String name, BigDecimal coef, BigDecimal decalage, Boolean reference) {
        this.name = name.toUpperCase();
        this.coef = coef;
        this.decalage = decalage;
        this.reference = reference;
    }

    public BigDecimal getDecalage() {
        return decalage;
    }

    public void setDecalage(BigDecimal decalage) {
        this.decalage = decalage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public BigDecimal getCoef() {
        return coef;
    }

    public void setCoef(BigDecimal coef) {
        this.coef = coef;
    }

    public Boolean isReference() {
        return reference;
    }
}
