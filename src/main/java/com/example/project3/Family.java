package com.example.project3;
import java.text.DecimalFormat;
/***
 * Class that helps initialize anything regarding the membership type, Family.
 * This class extends traits from Member.
 * @author Reiya Dave, Ifrah Sajjad
 */
public class Family extends Member{

    private boolean isFamMembership;
    private int guestPass;

    /***
     * Getter to help retrieve value for isFamMembership.
     * */
    public boolean getIsFamMembership(){
        return isFamMembership;
    }

    /***
     * Setter to help set the value of the isFamMembership.
     * */
    public void setIsFamMembership(boolean isFamMembership1){
        this.isFamMembership = isFamMembership1;
    }

    /***
     * Getter to help get the value of the guest passes left or available.
     * */
    @Override
    public int getGuestPass(){
        return guestPass;
    }

    /***
     * Setter to help set the value of guest passes
     * */
    @Override
    public void setGuestPass(int guestPass1){
        this.guestPass = guestPass1;
    } //each time command CG is used, guest pass goes down by 1


    /***
     * Method used to return the specific membership fee for Family membership
     * */
    @Override
    public String membershipFee() { 
        DecimalFormat df = new DecimalFormat("#.00");
        double total = (3*59.99) + 29.99;
        String result = df.format(total);
        return result;
    }

    /***
     * Method used to return a string of the member's information.
     * Ex: April March, DOB: 3/31/1990, Membership expires 6/30/2023, Location: PISCATAWAY, 08854, MIDDLESEX
     * */
    @Override
    public String toString(){
        String tempDob = this.getDob().getMonth() + "/" + this.getDob().getDay() + "/" + this.getDob().getYear();
        String tempExp = this.getExpire().getMonth() + "/" + this.getExpire().getDay() + "/" + this.getExpire().getYear();
        String result = this.getFname() + " " + this.getLname() + ", DOB: " + tempDob + ", Membership expires " + tempExp + ", Location: " + this.getLocation() + ", (Family) Guest-pass remaining: " + guestPass;
        return result;
    }
}
