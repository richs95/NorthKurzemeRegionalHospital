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
public class Person{
    private final String name; 
    private final String surname;
    public short age;
    private final int id;
    
    public Person(String name, String surname, short age, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public int getId() {
        return id;
    }
    
    public short getAge() {
        return age;
    }
    
    public void setAge(short age) {
        this.age = age;
    }
    
}
