/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richs
 */
public class DoctorTest {
    /* test */
    public DoctorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getOfficeNum method, of class Doctor.
     */
    @Test
    public void testGetOfficeNum() {
        System.out.println("getOfficeNum");
        Doctor instance = null;
        short expResult = 0;
        short result = instance.getOfficeNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeciality method, of class Doctor.
     */
    @Test
    public void testGetSpeciality() {
        System.out.println("getSpeciality");
        Doctor instance = null;
        String expResult = "";
        String result = instance.getSpeciality();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
