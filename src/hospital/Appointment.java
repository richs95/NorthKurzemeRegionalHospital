/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Richs
 */
class Appointment {
    private final int AppointmentID;
    private Date date;
    private String Description;
    private ArrayList<Doctor> doctorList;

    public Appointment(int AppointmentID, Date date,ArrayList<Doctor> doctorList, String Description) {
        this.AppointmentID = AppointmentID;
        this.date = date;
        this.Description = Description;
        this.doctorList = doctorList;
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public void printInvolvedDoctors(){
        for(int i = 0; i < doctorList.size(); i++) {   
            System.out.print("Doctor: " +doctorList.get(i)+ " " + doctorList.get(i).getName()+ " " + doctorList.get(i).getSurname()+ " " + doctorList.get(i).getSpeciality() + "/n");
        } 
    }
    
    public void addNewDoctor(Doctor doctor){
        doctorList.add(doctor); 
    }
    
    public void removeExistingDoctor(int ID){
        if(ID >= 0 && ID < doctorList.size()){
            doctorList.remove(ID);
        }
    }
    
}
