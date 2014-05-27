package org.miage.unitconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sébastien
 */
public class TestConversion {
    
    public TestConversion() { }
            
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   
    
    @Test
    public void conversionSimple(){
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name,ref);
        type.addCoef("km", BigDecimal.valueOf(0.001)); 
        assertTrue((conversion.convert("m", BigDecimal.valueOf(1000.0), type, "km").compareTo(BigDecimal.ONE) == 0));
    }
    
    @Test
    public void conversionComplexe() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("mm", BigDecimal.valueOf(10000));
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("mm", BigDecimal.valueOf(238.423), type, "km").compareTo(BigDecimal.valueOf(0.0000238423)) == 0));
    }
    
    @Test 
    public void conversionEnRef() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("mm", BigDecimal.valueOf(1000));
        assertTrue((conversion.convert("m", BigDecimal.valueOf(22.3), type, "mm").compareTo(BigDecimal.valueOf(22300.0)) == 0));
    }
    
    @Test
    public void conversionComplexe2() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("dm", BigDecimal.valueOf(10));
        type.addCoef("km", BigDecimal.valueOf(0.001));
        assertTrue((conversion.convert("dm", BigDecimal.valueOf(0.456), type, "km").compareTo(BigDecimal.valueOf(0.0000456)) == 0));
    }
    
    @Test
    public void UniteInexistante() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertNull((conversion.convert("dm", BigDecimal.valueOf(0.456), type, "km")));
    }
    
    @Test
    public void DivisionParZero() {
        Converter conversion = new Converter();
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        type.addCoef("km", BigDecimal.valueOf(0.1));
        assertNull((conversion.convert("km", BigDecimal.valueOf(0), type, "m")));
    }
    
    @Test
    public void coefDejaPresent() {
        String name = "longueur";
        String ref = "m";
        Type type = new Type(name, ref);
        assertFalse(type.addCoef("m", BigDecimal.valueOf(10.0)));
    }
}
