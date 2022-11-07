package com.example.project3;
import java.util.ArrayList;

/***
 *
 * Initiates a fitness class that gets put into the class schedule
 * @author Reiya Dave, Ifrah Sajjad
 */
public class FitnessClass{
    //int max = 1000;
    private String instructor;
    private String className;
    private Location classLocation;
    private Time classTime;
    //private Member[] classMembers;
    private ArrayList<Member> classMembers;
    private ArrayList<Member> classGuests;
    //private int size;

    /**
     * Constructor for FitnessClass, references to classMembers arraylist and classGuests arraylist
     * */
    public FitnessClass(){
        //this.classMembers = new Member[max];
        //this.size = 0;
        this.classMembers = new ArrayList<Member>();
        this.classGuests = new ArrayList<Member>();
    }

    /**
     * Getter for Instructor
     * */
    public String getInstructor(){
        return instructor;
    }

    /**
     * Setter for instructor
     * @param instructor1
     * */
    public void setInstructor(String instructor1){
        this.instructor = instructor1;
    }

    /**
     * Getter for className
     * */
    public String getClassName(){
        return className;
    }
    /**
     * Setter for className
     * @param className1
     * */
    public void setClassName(String className1){
        this.className = className1;
    }

    /**
     * Getter for class Location
     * */
    public Location getClassLocation(){
        return classLocation;
    }
    /**
     * Setter for class Location
     * @param classLocation1
     * */
    public void setClassLocation(Location classLocation1){
        this.classLocation = classLocation1;
    }

    /**
     * Getter for class time
     * */
    public Time getClassTime(){
        return classTime;
    }

    /**
     * Setter for className
     * @param classTime1
     * */
    public void setClassTime(Time classTime1){
        this.classTime = classTime1;
    }

    /**
     * Getter for class members
     * */
    public ArrayList<Member> getClassMembers(){
        return classMembers;
    }

    /**
     * Getter for class members
     * @param classMembers1
     * */
    public void setClassMembers(ArrayList<Member> classMembers1){
        this.classMembers = classMembers1;
    }

    /**
     * Adds member to classMembers arraylist
     * @return boolean
     * @param member
     * */
    public boolean addMember(Member member){
        /*this.classMembers[size] = member;
        size++;*/
        classMembers.add(member);
        return true;

    }

    /**
     * Adds guest to classGuests arraylist
     * @return boolean
     * @param member
     * */
    public boolean addGuest(Member member){

        classGuests.add(member);
        return true;
    }

    /**
     * Removes guest from classGuests arraylist
     * @return boolean
     * @param member
     * */
    public boolean removeGuest(Member member){

        return classGuests.remove(member);
    }


    /**
     * Find method to help search for a member
     * @return int
     * @param member
     * */
    public int find(Member member){
        if (classMembers != null){
            for(int i = 0; i < classMembers.size(); i++){
                if (member.getFname().toLowerCase().equals(this.classMembers.get(i).getFname().toLowerCase()) && member.getLname().toLowerCase().equals(this.classMembers.get(i).getLname().toLowerCase()) && member.getDob().compareTo(this.classMembers.get(i).getDob())==0)
                    return i;
            }
        }
        return -1;  //CHANGE TO RETURN NOT_FOUND AS CONSTANT IDENTIFIER FOR -1
    }

    /**
     * Remove method used to help remove a member from the classMembers arraylist
     * @return boolean
     * @param member
     * */
    public boolean removeMember(Member member){
        int removeMembIndex = find(member);
        //Member[] temp = new Member[size-1];
        if (removeMembIndex != -1){
            classMembers.remove(removeMembIndex);
            return true;

        }
        return false;
    }

    /**
     * Method that prints the participants and guests for a class
     * */
    public String printClass(){
        String result = "";
        if (classMembers.size() != 0){
            //System.out.println("\t- Participants -");
            result = "\t- Participants -\n";
            for (int i = 0; i < classMembers.size(); i++){
                //System.out.println("\t\t" + this.classMembers.get(i).toString());
                result += "\t\t" + this.classMembers.get(i).toString() + "\n";
            }
        }
        if (classGuests.size() != 0){
            //System.out.println("\t- Guests -");
            result += "\t- Guests -\n";
            for (int i = 0; i < classGuests.size(); i++){
                //System.out.println("\t\t" + this.classGuests.get(i).toString());
                result += "\t\t" + this.classGuests.get(i).toString() + "\n";
            }
        }
        return result;
    }


    /**
     * Converts result to a string
     * @return String
     * */
    public String toClassString(){
        /*classSchedule.getFitnessClass()[i].getClassName().toUpperCase() + " - " 
            + classSchedule.getFitnessClass()[i].getInstructor().toUpperCase() + ", " 
            + classSchedule.getFitnessClass()[i].getClassTime().getHour() + ":" 
            + classSchedule.getFitnessClass()[i].getClassTime().getMin() + " " +
            classSchedule.getFitnessClass()[i].getClassLocation().getTownship().toUpperCase()*/

            String result = this.className.toUpperCase() + " - " + this.instructor.toUpperCase() + ", " + this.classTime.getHour() + ":" + this.classTime.getMin()
            + ", " + classLocation.getTownship().toUpperCase();
            return result;
    }

}