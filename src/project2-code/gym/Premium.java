package gym;
import java.text.DecimalFormat;
/***
 * Class that helps initialize anything regarding the membership type, Premium.
 * @author Reiya Dave, Ifrah Sajjad
 */
public class Premium extends Family{
    //private Member[] prem;   //stores members with premium memberships
    //private int size;
    private boolean isPremMembership;
    private int guestPass;

    /**
     * Getter for Premium Membership
     * */
    public boolean getIsPremMembership(){
        return isPremMembership;
    }
    /**
     * Setter for Premium Membership
     * */
    public void setIsPremMembership(boolean isPremMembership1){
        this.isPremMembership = isPremMembership1;
    }

    /**
     * Getter for the remainder or amount of guest passes
     * @return int
     * */
    @Override
    public int getGuestPass(){
        return guestPass;
    }

    /**
     * Setter for the remainder of guest passes
     * @param guestPass1
     * */
    @Override
    public void setGuestPass(int guestPass1){
        this.guestPass = guestPass1;
    }
  

    /**
     * Method for the amount of membership fee for premium membership
     * @return String
     * */
    @Override
    public String membershipFee() { 
        DecimalFormat df = new DecimalFormat("#.00");
        double total = 11*59.99;
        String result = df.format(total);
        return result;
    }

    /**
     * Method that returns a string of the member's information
     * @return String
     * */
    @Override
    public String toString(){
        //returns a string of the member info
        //Ex: April March, DOB: 3/31/1990, Membership expires 6/30/2023, Location: PISCATAWAY, 08854, MIDDLESEX
        String tempDob = this.getDob().getMonth() + "/" + this.getDob().getDay() + "/" + this.getDob().getYear();
        String tempExp = this.getExpire().getMonth() + "/" + this.getExpire().getDay() + "/" + this.getExpire().getYear();
        String result = this.getFname() + " " + this.getLname() + ", DOB: " + tempDob + ", Membership expires " + tempExp + ", Location: " + this.getLocation() + ", (Premium) Guest-pass remaining: " + guestPass;
        return result;
    }
       
}
