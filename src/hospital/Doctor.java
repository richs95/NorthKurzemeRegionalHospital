/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author Richs
 */
public class Doctor extends Person{
    
    private final short OfficeNum;
    private final String Speciality;

    public Doctor(String name, String surname, short age, int id, short OfficeNum, String Speciality) {
        super(name, surname, age, id);
        this.OfficeNum = OfficeNum;
        this.Speciality = Speciality;
    }
    
    public short getOfficeNum() {
        return OfficeNum;
    }

    public String getSpeciality() {
        return Speciality;
    }
    
}
