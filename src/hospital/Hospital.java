/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Richs
 */
public class Hospital {
    
    ArrayList<Patient> patientList;
    ArrayList<Doctor> doctorList;
    
      // Manage Patient List
    public void printAllPatients(ArrayList<Patient> Patients) {
        for(int i = 0; i < Patients.size(); i++) {   
            //System.out.print(" " + Patients.get(i));
            System.out.print("Patient: " + Patients.get(i).getName()+ " " +  Patients.get(i).getSurname()+ " Age: " + Patients.get(i).getAge() +"\n");           

        }  
    }
    //Adds a new patient in arraylist
    public void addNewPatient(Patient newPatient) {
        patientList.add(newPatient);
    }
    //delete object from arraylist by ID
    public boolean deleteExistingPatientByID(int ID) {
        try{ 
//        if (ID == null) { 
//            return false; //return false if there is no such a thing in the list
//        } else { 
//            patientList.remove(ID); //if there is that kind of index in the list, delete info. in given object position
//            return true; //return true statement if it's all good
//        }
            //2.variants  
//               for(int i = 0; i < patientList.size(); i++){
//                   if(patientList.get(i).getId() == ID){    
//                             patientList.remove(patientList.get(i).getId());
//                             return true;
//                   }
//foreach
//objekt index salidzina idzsh un atrgriez true
//if b = index
       // remove patient
      
            for(Patient patient: patientList){
                if(patient.getId() == (Integer)ID){
                    patientList.remove(ID);
                    return true;
                }
            }
            }catch(NullPointerException e){
                System.err.println("Caught NullPointerException: " + e.getMessage());
            }
            catch(IndexOutOfBoundsException e){
                System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
            }
        return false;
    }
    
    //Delete Object from arraylist by object
    public boolean deleteExistingPatientByObject(Patient patient) {
         if (patient != null) { 
            patientList.remove(patient); //if there is that kind of index in the list, delete info. in given object position
            return true; //return true statement if it's all good
        } else {
            return false; //return false if there is no such a thing in the list
        }   
    }
    
     // For a given date, print all patients that must show up in the hospital
    public void printAllPatientsForDate(Date date) {
        for(int i = 0; i < patientList.size(); i++){
            for(int j = 0; j < patientList.get(i).getAppointmentList().size(); j++){
                if(patientList.get(i).getAppointmentList().get(j).getDate().equals(date)){
                    System.out.print(patientList.get(i));
                }
            }
        }
    }
    
    // Manage Appointments of specific patient with id = PatientID
    public void printAllAppointmentsForPatient(int PatientID) {     
       // for(int i = 0; i < patientList.size(); i++){
         //   for(int j = 0; j < patientList.get(i).getAppointmentList().size(); j++){
           //      if(patientList.get(i).getAppointmentList().get(j).getAppointmentID() == PatientID){
             //       System.out.print(patientList.get(i));
                   // System.out.print(patientList.get(i).getAppointmentList().get(j).getAppointmentID());
               //  }
           // }
        //}
        for(int i = 0; i < patientList.size(); i++){
            if(patientList.get(i).getId() == PatientID){    
                 //for(int j = 0; j < patientList.get(i).getAppointmentList().size(); j++){
                     patientList.get(i).printAllAppointments();
            }else
                System.out.println("Nuthin...");
        }
    }        
    
    public void makeNewAppointment(int PatientID, int AppointmentID, String Date, ArrayList<Doctor> Doctors) throws ParseException {
        //this.doctorList = Doctors;
        //foreach lai match dates - lai viena laika nebutu 
        SimpleDateFormat sd1 = new SimpleDateFormat("MM/dd/yyyy");
        Date dateTemp = sd1.parse(Date);
        Appointment appoTemp = new Appointment(AppointmentID, dateTemp, Doctors, "New Appointment");
        patientList.get(PatientID).subscribeNewAppointment(appoTemp);
        
    }
    
    public void deleteAppointment(int PatientID, int AppointmentID) {
         for(int i = 0; i < patientList.size(); i++){
            for(int j = 0; j < patientList.get(i).getAppointmentList().size(); j++){
                if(patientList.get(i).getAppointmentList().get(j).getAppointmentID() == PatientID){
                    doctorList.remove(AppointmentID);
                }
            }
         }
        //doctorList.remove(AppointmentID);///
    }

    //Manage list of all possible Doctors
    public void printAllDoctors(ArrayList<Doctor> Doctors) {
         for(int i = 0; i < Doctors.size(); i++) {   
            System.out.print("Doctor: " + Doctors.get(i).getName()+ " " +  Doctors.get(i).getSurname()+ " Age: " + Doctors.get(i).getAge()+ " Spec: " + Doctors.get(i).getSpeciality() +"\n");           
        }  
    }
    
    public void addNewDoctor(Doctor newDoctor) {
        doctorList.add(newDoctor);
    }
    
    public boolean deleteExistingDoctorByID(int ID) {
        if (ID != -1) { 
            doctorList.remove(ID); //if there is that kind of index in the list, delete info. in given object position
            return true; //return true statement if it's all good
        } else {
            return false; //return false if there is no such a thing in the list
        }
    }

    public boolean deleteExistingDoctorByObject(Doctor doctor) {
       // int pos = doctorList.indexOf(this); //inicialize index from object in variable 'pos'
       // if (pos != -1) { 
          if(doctor != null){
            doctorList.remove(doctor); //if there is that kind of index in the list, delete info. in given object position
            return true; //return true statement if it's all good
        } else {
            return false; //return false if there is no such a thing in the list
        }
    }
    public void generateAndSaveDoctors() throws FileNotFoundException, IOException {
        Doctor doc1 = new Doctor("Ivars", "Eglitis", (short)55, 2, (short)11, "Kirurgs"); 
        Doctor doc2 = new Doctor("Juris", "Upitis", (short)34, 3, (short)35, "Ortologs"); 
        Doctor doc3 = new Doctor("Raivis", "Klavins", (short)64, 4, (short)23, "Hiropraktikis");
        
        //ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList.add(doc1);
        doctorList.add(doc2);
        doctorList.add(doc3);
    
        FileOutputStream fout = new FileOutputStream("doctors.tmp");
        try (ObjectOutputStream oout = new ObjectOutputStream(fout)) {
            oout.writeObject(doctorList);
            System.out.println("genereted and saved doctor list in file");
        }
    }
    
    public ArrayList<Doctor> uploadDoctorList() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("doctors.tmp");
        try(ObjectInputStream ois = new ObjectInputStream(fis)){
            doctorList = (ArrayList<Doctor>) ois.readObject();
        }
        return doctorList;
    }
    
    public String generateDayPlanForDoctor(Doctor doctor){
        String dayplan = doctor.getName() + " " + doctor.getSurname() + "\n";
        
        final Random random = new Random();
        //creates random times in this day using LocalDateTime, LocalDate libaries
        for (int i = 0; i < 10; i++) {
            //panem sodienas datumu
            LocalDateTime time = LocalDateTime.of(LocalDate.now(),
            //inicialize datumu ar random stundu [8.00-18.00], minutem [0-60]
            LocalTime.of(random.nextInt(10) + 8, random.nextInt(60)));
            //System.out.println(time); //time test
            dayplan += "Time: " + time + ", patient: " + i + "\n";
        }
        System.out.println(dayplan);
        return dayplan;
    } 

    public Hospital() {
    }
    public static void main(String[] args) throws ParseException, IOException{ //parseexception for date, IO for generateAndSaveDoctors() 
            
        Hospital n = new Hospital();
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<Patient> patientList = new ArrayList<>();

        //n.generateDayPlanForDoctor(doc1);
        
        /**************************** 1. punkts ********************************/
        //Add doctors, patients and appointments (8 points)
        
        //Pievieno doctors
        Doctor doc1 = new Doctor("Ivars", "Eglitis", (short)55, 1, (short)11, "Kirurgs"); 
        Doctor doc2 = new Doctor("Juris", "Upitis", (short)34, 2, (short)35, "Ortologs"); 
        Doctor doc3 = new Doctor("Raivis", "Klavins", (short)64, 3, (short)23, "Hiropraktikis"); 
        Doctor doc4 = new Doctor("Andrejs", "Liepa", (short)44, 4, (short)25, "Arsts");
        
        //pievieno patients 
        Patient pat1= new Patient("Juris", "Berzs", (short)33, 1, appointmentList);
        Patient pat2= new Patient("Signe", "Lapina", (short)23, 2, appointmentList);   
        Patient pat3= new Patient("Eva", "Kocina", (short)35, 3, appointmentList);
        Patient pat4= new Patient("Guntis", "Hendrijs", (short)32, 2, appointmentList);
        
        //datuma inicializesana prieks appointments
        String s = "09/22/2006";
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = sd.parse(s);
        //
        String s1 = "09/22/2015";
        SimpleDateFormat sd1 = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = sd1.parse(s1);
        
        //Appointments izveidosana, inicializesana
        Appointment appo1 = new Appointment(1, date1, doctorList, "1.vizite urologs"); 
        Appointment appo2 = new Appointment(2, date2, doctorList, "2.vizite pote");
        Appointment appo3 = new Appointment(3, date1, doctorList, "3.vizite stomatologs");
        Appointment appo4 = new Appointment(4, date1, doctorList, "4.vizite dakteris");

        /**************************** 2. punkts ********************************/
        //Delete doctors, patients and appointments (8 points)
        
        
        
        
        
        /**************************** 3. punkts ********************************/
        //Pre-define list of doctors, patients and appointments for test usage. Create at least 3 doctors, 3 patients and 3 appointments (9 points)
        doctorList.add(doc1);
        doctorList.add(doc2);
        doctorList.add(doc3);
       // System.out.print("  " + doc1.getName() + "  " + doc1.getSurname() + "  Age:" + doc1.getAge()+ "  Spec:" + doc1.getSpeciality()+ "  Of.n:" + doc1.getOfficeNum()+ "\n");
       // n.deleteExistingDoctorByID(2);
        
        patientList.add(pat1);
        patientList.add(pat2);
        patientList.add(pat3);
        //n.printAllPatientsForDate(date1);
        
//TESTING
        System.out.println("\n Before Patients: ");
        n.printAllPatients(patientList);
        n.deleteExistingPatientByID(2);
        //patientList.remove(2);
        System.out.println("\n After Patients: ");
        n.printAllPatients(patientList);
        
        
        
        appointmentList.add(appo1);
        appointmentList.add(appo2);
        appointmentList.add(appo3);
        
        //n.deleteAppointment(3, 4);
        
        System.out.println("Appo3: \n");
        System.out.println("ID: " + appo3.getAppointmentID() + " Desp: " + appo3.getDescription() + "\n");
        
        System.out.println("\n Doctors: ");
        n.printAllDoctors(doctorList);
        System.out.println("\n Patients: ");
        //n.printAllPatients(patientList);
        System.out.println("\n Appointments: ");
        //n.printAllAppointmentsForPatient(1);//vai man ir appontmenti pielikti patientam??
        /**************************** 4. punkts ********************************/
        //Verifications - remember that doctors can’t be in the different appointments at the same time (9 points)
        
        
        /**************************** 5. punkts ********************************/
        //*Generate the day plan of the specific doctor (10 points)
        System.out.println("\n Generate day plan: ");
        n.generateDayPlanForDoctor(doc1);
        /**************************** 6. punkts ********************************/
        //*Generate doctor list and save it in file. Upload when it is necessary (10 points)
        //n.generateAndSaveDoctors();

    }
}
