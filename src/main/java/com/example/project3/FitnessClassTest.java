package com.example.project3;
import com.example.project3.Date;
import com.example.project3.FitnessClass;

import static org.junit.Assert.*;

/***
 * Fitness Class Test Case File used to run our own test cases for the methods that add and remove guests and members.
 * @author Reiya Dave, Ifrah Sajjad
 */
public class FitnessClassTest {

    /***
     * Method that checks test case against the method addMember from FitnessClass
     * */
    @org.junit.Test
    public void addMember() {
        Member member = new Member();
        FitnessClass pilates2 = new FitnessClass();
        String newFname = "Ally";
        member.setFname(newFname);
        String newLname = "Smith";
        member.setLname(newLname);
        Date dob = new Date("12/01/2001");
        member.setDob(dob);
        boolean expectedOutput = true;
        boolean actualOutput = pilates2.addMember(member);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("**Test case #1: this member does not exist ");
    }

    /***
     * Method that checks test case against the method addGuest from FitnessClass
     * */
    @org.junit.Test
    public void addGuest() {
        Member member = new Member();
        FitnessClass cardio2 = new FitnessClass();
        String newFname = "John";
        member.setFname(newFname);
        String newLname = "Smith";
        member.setLname(newLname);
        Date dob = new Date("09/10/1980");
        member.setDob(dob);
        boolean expectedOutput = true;
        boolean actualOutput = cardio2.addGuest(member);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("**Test case #2: this member has added a guest ");
    }

    /***
     * Method that checks test case against the method removeGuest from FitnessClass
     * */
    @org.junit.Test
    public void removeGuest() {
        Member member = new Member();
        FitnessClass spinning2 = new FitnessClass();
        String newFname = "Jane";
        member.setFname(newFname);
        String newLname = "Kelly";
        member.setLname(newLname);
        Date dob = new Date("11/10/1999");
        member.setDob(dob);
        boolean expectedOutput = false;
        boolean actualOutput = spinning2.removeGuest(member); //member= jane smith
        assertEquals(expectedOutput, actualOutput);
        System.out.println("**Test case #3: false; member is removing guest that does not exist ");
    }

    /***
     * Method that checks test case against the method removeMember from FitnessClass
     * */
    @org.junit.Test
    public void removeMember() {
        Member member = new Member();
        FitnessClass pilates2 = new FitnessClass();
        String newFname = "Jane";
        member.setFname(newFname);
        String newLname = "Smith";
        member.setLname(newLname);
        Date dob = new Date("10/10/2000");
        member.setDob(dob);
        boolean expectedOutput = false;
        boolean actualOutput = pilates2.removeMember(member);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("**Test case #4: this member does not exist ");

    }
}