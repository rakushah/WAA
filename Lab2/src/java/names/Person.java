/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

/**
 *
 * @author Owner
 */
public class Person {
    private int key;
    private String firstName;
    private String lastName;
    
    public Person(int key,String fname,String lname){
        this.key=key;
        this.firstName=fname;
        this.lastName=lname;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    
    public String toString(){
        return "Key = "+ key +" First Name = "+firstName+" Last Name = "+lastName;
    }
}
