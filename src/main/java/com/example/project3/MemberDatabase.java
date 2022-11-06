package com.example.project3;

import com.example.project3.Family;
import com.example.project3.Member;

/**
 * Initializes database for which members are stored in. Assists with finding a member within database, adding member
 * to database, removing member from database, and printing database based on different sorting parameters.
 * @author Ifrah Sajjad, Reiya Dave
 **/

public class MemberDatabase {
    /**Array that stores members into main gym database*/
    private Member[] mlist;
    /**Amount of members in mlist/main gym database*/
    private int size;   //number of members in array-NOT array length
    public static final int NOT_FOUND = -1;

    /**Constructor to initialize member database*/
    public MemberDatabase() {
        this.mlist = new Member[4];
        this.size = 0;
    }

    

    //returns index
    /**Takes in member parameter and searches for it in member database,
     * returns NOT_FOUND if not found
     * @param member memb
     * @return int
     * */
    private int find(Member member){
        for(int i = 0; i < this.size; i++){
            if (member.getFname().toLowerCase().equals(this.mlist[i].getFname().toLowerCase()) && member.getLname().toLowerCase().equals(this.mlist[i].getLname().toLowerCase()) && member.getDob().compareTo(this.mlist[i].getDob())==0)
                return i;
        }
        return NOT_FOUND;  //CHANGE TO RETURN NOT_FOUND AS CONSTANT IDENTIFIER FOR -1
    }

    /**
     * Public version of find method
     * @return Member
     * @param member
     * */
    public Member pubFind(Member member){
        for(int i = 0; i < this.size; i++){
            if (member.getFname().toLowerCase().equals(this.mlist[i].getFname().toLowerCase()) && member.getLname().toLowerCase().equals(this.mlist[i].getLname().toLowerCase()) && member.getDob().compareTo(this.mlist[i].getDob())==0)
                return mlist[i];
        }
        return null;
    }

    /**Grows member database by 4 each time database becomes full
     * */
    private void grow(){
        //create new array with length increased by 4
        //copy contents of old array to new array
        Member[] tempMlist = new Member[this.mlist.length + 4];
        for (int i = 0; i < mlist.length; i++){
            tempMlist[i] = mlist[i];
        }
        this.mlist = tempMlist;

    }
    /**Takes in member parameter and adds member to gym member database
     * @param member
     * @return boolean
     */
    public boolean add(Member member){
        //if array length is full, then grow
        if (find(member) != -1){
            return false;
        }
        if (this.size == this.mlist.length){
            grow();
        }

        //increase size by one and add new member to the new index (which is new size value)
        this.mlist[size] = member;
        size++;
        //System.out.println(size);   //test
        return true;


    }
    /**Takes in member parameter and removes member from gym member database
     * @param member
     * @return boolean
     * */
    public boolean remove(Member member){
        //find member to remove, if its there then
        int removeMembIndex = find(member);
        Member[] temp = new Member[size-1];
        if (removeMembIndex != -1){
            for (int i = 0, j = 0; i < size; i++){
                if (i != removeMembIndex){
                    temp[j++] = mlist[i];
                }
            }
            mlist = temp;
            size--;
            return true;

        }
        return false;

    }


    /** Prints out gym member database in string format
     * */
    public void print(){
        //print the array contents as is
        //do something abt it possibly printing empty indexes
        if (this.size == 0){
            System.out.println("Member database is empty!");
        }
        else{
            System.out.println("-list of members-");
            for(int i = 0; i < this.size; i++){
                System.out.println(mlist[i].toString());
            }
            System.out.println("-end of list-");
        }

    }
    /** Prints out gym member database in string format, sorting by county, and then zipcode
     * */
    public void printByCounty(){
        //sort by county and then zipcode
        //insertion sort
        if (this.size == 0){
            System.out.println("Member database is empty!");
            return;
        }

        for (int i = 0; i < size; i++){
            Member key = mlist[i];
            if (key == null)
                break;
            int j = i - 1;
            if (j > -1) {
                while (j >= 0 && mlist[j].getLocation().getCounty().compareTo(key.getLocation().getCounty()) >= 0){
                    if(mlist[j].getLocation().getCounty().compareTo(key.getLocation().getCounty()) == 0 && !(mlist[j].getLocation().getZipcode().compareTo(key.getLocation().getZipcode()) > 0)) {
                        break;
                    }
                    mlist[j + 1] = mlist[j];
                    j = j - 1;
                }
                mlist[j+1] = key;
            }

        }
        System.out.println("-list of members sorted by county and zipcode-");
        for(int i = 0; i < this.size; i++){
            System.out.println(mlist[i].toString());
        }
        System.out.println("-end of list-");

    }
    /** Prints out gym member database in string format, sorting by membership expiration date
     * */
    public void printByExpirationDate(){
        //sort by the expiration date
        if (this.size == 0){
            System.out.println("Member database is empty!");
            return;
        }
        Member temp;
        for(int i=0; i< size; i++){
            for(int j= i+1; j<size; j++){
                if(mlist[i].getExpire().compareTo(mlist[j].getExpire()) > 0){
                    temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
            }
        }
        System.out.println("-list of members sorted by membership expiration date-");
        for(int i = 0; i < this.size; i++){
            System.out.println(mlist[i].toString());
        }
        System.out.println("-end of list-");
    }
    /** Prints out gym membership database in string format, sorting by last name, then first name
     * */
    public void printByName(){
        //sort by last name and then first name
        //use compareTo()
        if (this.size == 0){
            System.out.println("Member database is empty!");
            return;
        }

        //SORTING ALGO          
        Member temp;
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                if (mlist[i].compareTo(mlist[j]) > 0){
                    //swap
                    temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
            }
        }
        System.out.println("-list of members sorted by last name, and first name-");
        for(int i = 0; i < this.size; i++){
            System.out.println(mlist[i].toString());
        }
        System.out.println("-end of list-");

    }

    /**
     * Method that prints members followed by their membership fees
     * */
    public void printByMembershipFee(){
        if (this.size == 0){
            System.out.println("Member database is empty!");
        }
        else{
            System.out.println("-list of members with membership fees-");
            for(int i = 0; i < this.size; i++){
                if(mlist[i] instanceof Family == true){

                    System.out.println(mlist[i].toString() + " (Family) guest-pass remaining: " + " Membership fee: $" + mlist[i].membershipFee());
                }else if(mlist[i] instanceof Premium == true){
                    System.out.println(mlist[i].toString() + " (Premium) guest-pass remaining: " + " Membership fee: $" + mlist[i].membershipFee());
                }else{ //standard
                    System.out.println(mlist[i].toString() + " Membership fee: $" + mlist[i].membershipFee());
                }//remember when to check guest passes 
            }
            System.out.println("-end of list-");
        }
    }



}

