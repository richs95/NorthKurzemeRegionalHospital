/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;

/**
 *
 * @author Richs
 */
public class Patient extends Person{
    
    ArrayList<Appointment> Appointments;

    Patient(String name, String surname, short age, int id, ArrayList<Appointment> Appointments) {
        super(name, surname, age, id);
        this.Appointments = Appointments;
    }
    
    public void printAllAppointments(){
        for(int i = 0; i < Appointments.size(); i++) {   
            System.out.print("Appointment: " + Appointments.get(i).getAppointmentID() + " Date: " + Appointments.get(i).getDate()+ " Description: " + Appointments.get(i).getDescription() +"\n");
        } 
        //Prints all appointments 
        //[ID, Date, Office Num, Description]
        //Involved Doctor 1
        //Involved Doctor 2
        //...
        //Involved Doctor N
        
        //[ID, Date, Office Num, Description]
        //Involved Doctor 1
        //Involved Doctor 2
        //...
        //Involved Doctor N
        
        //etc
          
    }
    
    void subscribeNewAppointment(Appointment appointment) {
        Appointments.add(appointment);
    }
    
    public void deleteExistingAppointment(int id) {
        Appointments.remove(id);
    }
    
    ArrayList<Appointment> getAppointmentList() {
      return Appointments;
    }
    
}
