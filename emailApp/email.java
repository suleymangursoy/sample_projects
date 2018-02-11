/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailApp;

import java.util.Scanner;

/**
 *
 * @author Suleyman Gursoy
 */
public class email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String emailSyntax;
    private String department;
    private int mailBoxCapacity ;
    private int defaultMailCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "gat.com";

    // consructor to receive first name and last name
    public email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName );
        
        // call a method for setting department
        this.department = setDepartment();
        
        // call a method that returns a fixed size string
        this.password = randomPassword(defaultPasswordLength);
        
        // creating email syntax
        
        this.emailSyntax = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department+"." + companySuffix;
        
        // set the mail box capacity
        
        setMailCapacity(defaultMailCapacity);
        
        //
        
        
    }
    //  ask for department
    public String setDepartment(){
        System.out.print("Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for None \nEnter Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch(depChoice){
            case 1: return "sales";
            case 2: return "dev";
            case 3: return "acct";
            default: return "";
    }
    }
    
    
    // generate a random password
    
    public String randomPassword(int length){
        String passwordSet = "abcdefghıklmnopqrstuwxyz0123456789+-*/,.";
        char[] password = new char[length];
        for(int i = 0; i < length;i++ ){
            int rand =(int) (Math.random()*length);
            password[i] = passwordSet.charAt(rand);
        }
        System.out.println("Your random password is: " + password);
        return new String(password);
    }
    
    
    //set the mail box capacity
    public void setMailCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    
    // set the alternate email 
    public void setAltMail(String email){
        this.alternateEmail = email;
    }
    
    // change the password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getCapacity(){return this.mailBoxCapacity;}
    public String getAltMail(){return this.alternateEmail;}
    public String getPassword(){return this.password;}
    
    public String showInfo(){
        return "Name-Surname: " + this.firstName + " " + this.lastName+
                "\nCompany Email: " + this.emailSyntax + " " + "\nMailbox Capacity: " + this.mailBoxCapacity;
    }
    
}
