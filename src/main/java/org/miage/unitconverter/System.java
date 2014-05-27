/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.miage.unitconverter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MORIN
 */
public class System {
    private String name;
    private List<Type> typeList;

    public System(String name) {
        this.name = name;
        this.typeList = new ArrayList<>();
    }
    
    public void addType(Type type){
        if(typeList != null){
            typeList.add(type);
        }
    }
    
    public boolean removeType(String name){
        for (Type t : typeList){
            if (t.getNom().equals(name)){
                typeList.remove(t);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
    
    
}
