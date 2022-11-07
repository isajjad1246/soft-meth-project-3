package com.example.project3.gym;
import com.example.project3.Date;
import com.example.project3.Location;
import com.example.project3.Member;
import com.example.project3.Premium;

import static org.junit.Assert.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/***
 *
 * Test Class for the method membershipFee() in Premium
 * @author Reiya Dave, Ifrah Sajjad
 */
public class PremiumTest {

    /**
     * Method that tests if the membership fee is a valid amount based on the membership type
     * */
    @org.junit.Test
    public void check_membershipFee_valid() {
        Member member = new Premium();
        String newFname = "Reiya";
        member.setFname(newFname);
        String newLname = "Dave";
        member.setLname(newLname);
        Date dob = new Date("2/2/2002");
        member.setDob(dob);
        member.setLocation(Location.PISCATAWAY);
        double expectedAmt = 659.89;
        double actualAmt = Double.parseDouble(member.membershipFee());
        assertEquals(expectedAmt, actualAmt, 0);
    }

    /**
     * Method that tests if the membership fee is a not a valid amount
     * */
    @org.junit.Test
    public void check_prem_mem_notValid(){
        Member member = new Premium();
        String newFname = "Reiya";
        member.setFname(newFname);
        String newLname = "Dave";
        member.setLname(newLname);
        Date dob = new Date("2/2/2002");
        member.setDob(dob);
        member.setLocation(Location.PISCATAWAY);
        double expectedAmt = 659.89;
        double actualAmt = Double.parseDouble(member.membershipFee());
        assertNotEquals(expectedAmt, actualAmt, 0);

    }
}