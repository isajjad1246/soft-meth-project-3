package gym;

import static org.junit.Assert.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/***
 * Class that tests the method isValid() from Date Class
 * @author Reiya Dave, Ifrah Sajjad
 */
public class DateTest {

    /**
     * Method that checks various test cases against method isValid(), checking if the given dates are valid or not
     * */
    @org.junit.Test
    public void isValid() {
        Date date = new Date("03/29/2022");
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #1: this is a valid date and meets all the requirements for a valid date ");
        assertEquals(expectedOutput, actualOutput);

        date = new Date("2/29/2020");
        expectedOutput = true;
        actualOutput = date.isValid();
        System.out.println("**Test case #2: there's 29 days in February during a leap year ");
        assertEquals(expectedOutput, actualOutput);


        date = new Date("2/31/2021");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.println("**Test case #3: this date is invalid due to there being over 28 days in February during a non-leap year ");
        assertEquals(expectedOutput, actualOutput);

        date = new Date("1/1/1999");
        expectedOutput = true;
        actualOutput = date.isValid();
        System.out.println("**Test case #4: there's 31 days in January; this is within the range ");
        assertEquals(expectedOutput, actualOutput);

        date = new Date("10/32/2024");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.println("**Test case #5: this date is invalid due to there being over 31 days in October ");
        assertEquals(expectedOutput, actualOutput);

    }
}