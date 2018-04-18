/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richs
 */
public class PatientUnitTest {
    
    public PatientUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of printAllAppointments method, of class Patient.
     */
    @Test
    public void testPrintAllAppointments() {
        System.out.println("printAllAppointments");
        Patient instance = null;
        instance.printAllAppointments();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subscribeNewAppointment method, of class Patient.
     */
    @Test
    public void testSubscribeNewAppointment() {
        System.out.println("subscribeNewAppointment");
        Appointment appointment = null;
        Patient instance = null;
        instance.subscribeNewAppointment(appointment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteExistingAppointment method, of class Patient.
     */
    @Test
    public void testDeleteExistingAppointment() {
        System.out.println("deleteExistingAppointment");
        int id = 0;
        Patient instance = null;
        instance.deleteExistingAppointment(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointmentList method, of class Patient.
     */
    @Test
    public void testGetAppointmentList() {
        System.out.println("getAppointmentList");
        Patient instance = null;
        ArrayList<Appointment> expResult = null;
        ArrayList<Appointment> result = instance.getAppointmentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
