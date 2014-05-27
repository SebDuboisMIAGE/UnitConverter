package org.miage.unitconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sébastien
 */
import java.math.BigDecimal;


public class Converter {

    
    public BigDecimal convert(String startUnit, BigDecimal in, Type type, String endUnit){
        if (type.isInList(startUnit) != null && type.isInList(endUnit) != null){
            if (!in.equals(BigDecimal.ZERO)){//TODO Attention si on fait les degrés celcius
                return convertReferenceToOut(endUnit, type, convertInToReference(startUnit, type, in));
            }            
        }
        return null;       
    }
    
    public BigDecimal convertInToReference(String startUnit, Type type, BigDecimal in){
        if(type != null && type.isInList(startUnit) != null){
            return (in.add(type.isInList(startUnit).getDecalage()).divide(type.isInList(startUnit).getCoef()));
        }
        return null;
    }
    
    public BigDecimal convertReferenceToOut(String endUnit, Type type,  BigDecimal inToRef){
        return type.isInList(endUnit).getCoef().multiply(inToRef.add(type.isInList(endUnit).getDecalage()));
    }
}
