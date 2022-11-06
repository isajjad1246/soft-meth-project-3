package com.example.project3;
import java.util.Calendar;
/** 
 * java util Calendar import that allows us to use the calendar class
 * */
import java.util.StringTokenizer;    
/**
 * importing string tokenizer class from java.util
 * */

/**
 * Initializes and creates Date objects for use within other classes. Dates involve a member's date of birth and
 * expiration date. Date class checks validity of given date and compares dates to other dates.
 * @author Reiya Dave, Ifrah Sajjad
 **/

public class Date implements Comparable<Date> {
    /**
     * private variable for year
     * */
    private int year;
    /**
     * private variable for month
     * */
    private int month;
    /**
     * private variable for day
     * */
    private int day;
    /**
     * final variable for January
     * */
    public static final int Jan = 01;
    /**
     * final variable for February
     * */
    public static final int Feb = 02;
    /**
     * final variable for March
     * */
    public static final int Mar = 03;
    /**
     * final variable for April
     * */
    public static final int Apr = 04;
    /**
     * final variable for May
     * */
    public static final int May = 05;
    /**
     * final variable for June
     * */
    public static final int Jun = 06;
    /**
     * final variable for July
     * */
    public static final int Jul = 07;
    /**
     * final variable for August
     * */
    public static final int Aug = 8;
    /**
     * final variable for September
     * */
    public static final int Sep = 9;
    /**
     * final variable for October
     * */
    public static final int Oct = 10;
    /**
     * final variable for November
     * */
    public static final int Nov = 11;
    /**
     * final variable for December
     * */
    public static final int Dec = 12;


    Calendar calendar = Calendar.getInstance();

    /**
     * retrieves year
     * @return int
     * */
    public int getYear() {

        return year;
    }

    /**
     * sets year
     * @param year2
     * */
    public void setYear(int year2) {

        this.year = year2;
    }

    /**
     * retrieves month
     * @return int
     * */
    public int getMonth() {

        return month;
    }

    /**
     * sets month
     * @param month2
     * */
    public void setMonth(int month2) {

        this.month = month2;
    }

    /**
     * retrieves day
     * @return int
     * */
    public int getDay() {

        return day;

    }

    /**
     * sets day
     * @param day2
     * */
    public void setDay(int day2) {

        this.day = day2;
    }

    /**
     * create an object with today's date (see Calendar class)
     * */
    public Date() {
        Calendar cal = Calendar.getInstance();
        this.year = cal.get(1);
        this.month = cal.get(2);
        this.day = cal.get(5) + 1;

        /*String Date = Calendar.getInstance().getTime().toString();
        

        // need to remove the time and time zone
        // ex: Wed Feb 20 14:40:37 UTC 2019
        StringTokenizer separator = new StringTokenizer(Date, " ");

        separator.nextToken();
        month = Integer.parseInt(separator.nextToken());

        day = Integer.parseInt(separator.nextToken());

        separator.nextToken();
        separator.nextToken();
        year = Integer.parseInt(separator.nextToken());*/


    }
    /**
     * take "mm/dd/yyyy" and create a Date object
     * @param date
     * */
    public Date(String date) {

        StringTokenizer todaysDate = new StringTokenizer(date, "/");

        month = Integer.parseInt(todaysDate.nextToken());

        day = Integer.parseInt(todaysDate.nextToken());

        year = Integer.parseInt(todaysDate.nextToken());

    }



    /**
     * regular compareTo method-> returning 1, 0, -1
     * if date 1 is earlier than date 2 then return 1
     * if date 1 is later, return -1
     * same date then return 0
     * @param Date
     * @return int
     */
    @Override
    public int compareTo(Date Date) {


        int month = Date.getMonth();
        /**
         * gets month from the Date inputted
         * */
        int year = Date.getYear();
        /**
         * gets year from the Date inputted
         * */
        int day = Date.getDay();
        /**
         * gets day from the Date inputted
         * */

        int month2 = this.getMonth();
        /**
         * creates instance for month from the Date inputted
         * */
        int year2 = this.getYear();
        /**
         * creates instance for year from the Date inputted
         * */
        int day2 = this.getDay();
        /**
         * creates instance for day from the Date inputted
         * */

        if (year < year2) {
            return 1;
        } else if (year > year2) {
            return -1;
        } else if (year == year2) {
            if (month < month2) {
                return 1;
            } else if (month > month2) {
                return -1;
            } else if (month == month2) {
                if (day < day2) {
                    return 1;
                } else if (day > day2) {
                    return -1;
                } else if (day == day2) {
                    return 0;
                }
            }
        }
        return 0;

    }

    /**
     * if the month is Jan, Mar, May, July, August, Oct, and Dec then it has 31 days
     * if the month is april, june, sept, nov then 30 days if its feb 28 days in a
     * NON leap year but 29 days in a leap year
     * - check if a date is a valid calendar date
     * @return boolean
     * */
    public boolean isValid() {



        int newYear = this.getYear();

        int newMonth = this.getMonth();

        int newDay = this.getDay();


        int currentYear = Calendar.getInstance().get(Calendar.YEAR);



        boolean leapYear = true;

        if (newMonth > Dec || newDay > 31) {
            return false;
        }

        if(newMonth < 1 || newDay < 1){
            return false;
        }

        if (newYear % 4 == 0){
            //go to step 2
            if (newYear % 100 == 0){
                //go to step 3
                if (newYear % 400 == 0){
                    leapYear = true;
                }
                else{
                    leapYear = false;
                }
            }
            else{
                leapYear = true;
            }
        }
        else{
            leapYear = false;
        }

            if (newMonth == Feb && leapYear == true) {
                if (newDay <= 29) {
                    return true;
                } else {
                    return false;
                }
            }
            else if (newMonth == Feb && leapYear == false) {
                if (newDay <= 28) {
                    return true;
                }
                else{
                    return false;
                }
            } else if (newMonth == Jan || newMonth == Mar || newMonth == May || newMonth == Jul || newMonth == Aug
                    || newMonth == Oct || newMonth == Dec ) {
                if (newDay <= 31) {
                    return true;
                } else {
                    return false;
                }
            } else if (newMonth == Apr || newMonth == Jun || newMonth == Sep || newMonth == Nov) {
                if (newDay < 31) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
    }

    /**
     * test bed main for isValid
     * */

    public static void main(String[] args){

        Date date = new Date("3/29/2022");
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #1: there's 31 days in March: ");
        testResult(date, expectedOutput, actualOutput);


        date = new Date("2/29/2020");
        expectedOutput = true;
        actualOutput = date.isValid();
        System.out.println("**Test case #2: there's 29 days in February during a leap year: ");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("2/31/2021");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.println("**Test case #3: this date is invalid due to there being over 28 days in February during a non-leap year: ");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("1/1/1999");
        expectedOutput = true;
        actualOutput = date.isValid();
        System.out.println("**Test case #4: there's 31 days in January; this is within the range: ");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("10/32/2024");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.println("**Test case #5: this date is invalid due to there being over 31 days in October: ");
        testResult(date, expectedOutput, actualOutput);
    }

    /**
     * helps test result of our own test cases
     * */

    private static void testResult(Date date, boolean expectedOutput, boolean actualOutput){
        System.out.println(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
        System.out.println("isValid() returns " + actualOutput);
        if(actualOutput == expectedOutput){
            System.out.println(", PASS.\n");
        }else{
            System.out.println(", FAIL.\n");
        }
    }

}

