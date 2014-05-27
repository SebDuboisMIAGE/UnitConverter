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
import java.util.ArrayList;
import java.util.List;


public class Type {

    private String nom;
    private List<Unit> coefList;
    
    public void setCoef(List<Unit> coef) {
        this.coefList = coef;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public List<Unit> getCoef() {
        return coefList;
    }
    public Type(String nom, String refName) {
        this.nom = nom;
        this.coefList = new ArrayList();
        this.coefList.add(new Unit(refName, BigDecimal.ONE, true));
    }
    
    public boolean addCoef(String nom, BigDecimal coef){
        if (nom != null && !nom.equals("") && !this.existInList(nom)){
            if(this.coefList != null){
                this.coefList.add(new Unit(nom, coef, false));
                return true;
            }
        }
        return false;
    }
    
    public boolean modifyCoef(String nom, BigDecimal coef){
        for(Unit u : coefList){
            if(u.getName().equals(nom)){
                u.setCoef(coef);
                return true;
            }
        }
        return false;
    }
    
    public boolean modifyDecalage(String nom, BigDecimal decalage){
        for(Unit u : coefList){
            if(u.getName().equals(nom)){
                u.setDecalage(decalage);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeCoef(String nom){
        for(Unit u : coefList){
            if(u.getName().equals(nom)){
                coefList.remove(u);
                return true;
            }
        }
        return false;
    }
    
    public Unit isInList(String name){
        for(Unit u : coefList){
            if(u.getName().equals(name.toUpperCase())){
                return u;
            }
        }
        return null;
    }
    
    public boolean existInList(String name){
        for(Unit u : coefList){
            if(u.getName().equals(name.toUpperCase())){
                return true;
            }
        }
        return false;
    }
    
    public Unit getReference(){
        for(Unit u : coefList){
            if(u.isReference()){
                return u;
            }
        }
        return null;
    }
}
