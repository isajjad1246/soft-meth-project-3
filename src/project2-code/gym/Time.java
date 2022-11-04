package gym;

/**
 * Enum that initializes the time object that fitness classes occur.
 * @author Ifrah Sajjad, Reiya Dave
 **/

public enum Time{//define the time of a fitness class in hh:mm
    //PILATES(9, 30),
    /**
     * Enum Time for Pilates Class
     * */
    //SPINNING (14, 00),
    /**
     * Enum Time for Spinning Class
     * */
    //CARDIO (14, 00);
    /**
     * Enum Time for Cardio Class
     * */

    MORNING (9, 30),
    AFTERNOON (14, 00),
    EVENING (18, 30);

    /**
     * Final variable for hours
     * */
    private final int hour;

    /**
     * Final variable for minutes
     * */
    private final int min;


    /***
     * Creates instance variables for hours and minutes
     * @param hour
     * @param min
     * */
    Time(int hour, int min){
        this.hour = hour;
        this.min = min;

    }

    /**
     * Retrieves hours
     * */
    Integer getHour(){
        return hour;
    }

    /**
     * Retrieves minutes
     * */
    Integer getMin(){
        return min;
    }

}

