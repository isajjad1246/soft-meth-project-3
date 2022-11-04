package gym;
import java.text.DecimalFormat;

/**
 * Initializes and creates Member objects for use within other classes. Assists with comparing String names with
 * each other as well as parsing Member objects as string types.
 * @author Ifrah Sajjad, Reiya Dave
 **/

public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**Retrieves first name of member
     * @return String
     * */
    public String getFname(){
        return fname;
    }
    /**Sets first name
     * @param newFname
     * */
    public void setFname(String newFname){
        this.fname = newFname;
    }
    /**Retrieves last name of member
     * @return String
     * */
    public String getLname(){
        return lname;
    }
    /**Sets last name
     * @param newLname */
    public void setLname(String newLname){
        this.lname = newLname;
    }
    /**Retrieves date of birth of member
     * @return Date*/
    public Date getDob(){
        return dob;
    }
    /**Sets date of birth
     * @param newDob */
    public void setDob(Date newDob){
        this.dob = newDob;
    }
    /**Retrieves membership expiration date of member
     * @return Date*/
    public Date getExpire(){
        return expire;
    }
    /**Sets expiration date
     * @param newExpire*/
    public void setExpire(Date newExpire){
        this.expire = newExpire;
    }
    /**Retrieves gym location of member’s membership
     * @return Location*/
    public Location getLocation(){
        return location;
    }
    /**Sets location
     * @param newLocation*/
    public void setLocation(Location newLocation){
        this.location = newLocation;
    }

    /**
     * Retrieves amount of guest passes
     * @return 0
     */
    public int getGuestPass(){
        return 0;
    }
    /**
     * Sets the amount of guest passes
     * @param guestPass1
     */
    public void setGuestPass(int guestPass1){
    }

    

    /**Converts member information into string output
     * @return String*/
    @Override
    public String toString(){
        //returns a string of the member info
        //Ex: April March, DOB: 3/31/1990, Membership expires 6/30/2023, Location: PISCATAWAY, 08854, MIDDLESEX
        String tempDob = this.getDob().getMonth() + "/" + this.getDob().getDay() + "/" + this.getDob().getYear();
        String tempExp = this.getExpire().getMonth() + "/" + this.getExpire().getDay() + "/" + this.getExpire().getYear();
        String result = this.getFname() + " " + this.getLname() + ", DOB: " + tempDob + ", Membership expires " + tempExp + ", Location: " + this.getLocation();
        return result;
        //done but double check
    }

    /**Checks if two members are equal to each other
     * @return boolean
     * @param obj*/
    @Override
    public boolean equals(Object obj){
        Member memb = (Member) obj;
        if(memb.getFname().equals(this.getFname()) && memb.getLname().equals(this.getLname()) && memb.getDob().equals(this.getDob())){
            return true;
        }
        return false;

    }

    /**Compares names of two members, seeing which comes before which in alphabetical order
     * @param member
     * @return int*/
    @Override
    public int compareTo(Member member){
        //used when sorting by name
        String name1 = this.getLname();  //check if this. should be there
        String name2 = member.getLname();
        //check in full if last names are equal
        //if equal, change strings to first name, if not equal, continue
        if (name1.equals(name2)){
            name1 = this.getFname();
            name2 = member.getFname();
        }

        for (int i = 0; i < name1.length(); i++){
            if (name1.charAt(i) > name2.charAt(i)){
                return 1;
            }
            else if (name1.charAt(i) < name2.charAt(i)){
                return -1;
            }
            else if (name1.charAt(i) == name2.charAt(i)){
                continue;
            }
            if (name2.length() == i + 1){
                return 1;
            }
        }
        //when name2 is longer than name 1 and has been same so far
        if (name2.length() > name1.length()){
            return -1;
        }
        else
            return 0;   //means names are same;
    }

    /***
     * Method used to set the value of the membership fee for standard membership
     * @return String
     */
    public String membershipFee() { 
        DecimalFormat df = new DecimalFormat("#.00");
        double total = (3*39.99) + 29.99;
        String result = df.format(total);
        return result;
    }

    /***
     * Main method to set test cases for compareTo method
     * */
    public static void main(String[] args){

        Member mem1 = new Member();
        Member mem2 = new Member();
        mem1.setFname("Jane");
        mem1.setLname("Doe");
        mem2.setFname("Mary");
        mem2.setLname("Apple");
        int expectedOutput = 1;
        int actualOutput = mem1.compareTo(mem2);
        System.out.println("** Test case #1: expected result is Mary Apple, Jane Doe: ");
        testResult(mem1, mem2, expectedOutput, actualOutput);


        mem1.setFname("John");
        mem1.setLname("Apple");
        mem2.setFname("Chris");
        mem2.setLname("Apple");
        expectedOutput = 1;
        actualOutput = mem1.compareTo(mem2);
        System.out.println("** Test case #2: expected result Chris Apple, John Apple: ");
        testResult(mem1, mem2, expectedOutput, actualOutput);


        mem1.setFname("John");
        mem1.setLname("Smith");
        mem2.setFname("John");
        mem2.setLname("Smithson");
        expectedOutput = -1;
        actualOutput = mem1.compareTo(mem2);
        System.out.println("** Test case #3: expected result is John Smith, John Smithson: ");
        testResult(mem1, mem2, expectedOutput, actualOutput);

        mem1.setFname("Carol");
        mem1.setLname("Apple");
        mem2.setFname("John");
        mem2.setLname("Apple");
        expectedOutput = -1;
        actualOutput = mem1.compareTo(mem2);
        System.out.println("** Test case #4: expected result is Carol Apple, John Apple: ");
        testResult(mem1, mem2, expectedOutput, actualOutput);

        mem1.setFname("Jane");
        mem1.setLname("Apple");
        mem2.setFname("Jane");
        mem2.setLname("Doe");
        expectedOutput = -1;
        actualOutput = mem1.compareTo(mem2);
        System.out.println("** Test case #5: expected result is Jane Apple, Jane Doe: ");
        testResult(mem1, mem2, expectedOutput, actualOutput);

    }

    /***
     * Test Result method to test our test cases for compareTo method
     * */
    private static void testResult(Member mem1, Member mem2, int expectedOutput, int actualOutput){
        System.out.println("Member 1: "+ mem1.getFname() + " " + mem1.getLname() + " " + "Member 2: " +mem2.getFname() + " " + mem2.getLname());
        System.out.println("compareTo() returns " + actualOutput);
        if (actualOutput == expectedOutput){
            System.out.println(", PASS. \n");
        }else{
            System.out.println(", FAIL. \n");
        }
    }

}
