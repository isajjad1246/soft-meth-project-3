package com.example.project3;
/**
 * Enum that initializes the location object for each member.
 * Parses location enum to a string.
 * @author Reiya Dave, Ifrah Sajjad
 */
    public enum Location {//define the 5 gym locations; refer to lecture note #2
        //edison, bridgewater, somerville, piscataway, franklin
        /**
         *
         * */
        BRIDGEWATER("Bridgewater", "08807", "Somerset"),
        /**
        * Contains the location for the Bridgewater gym: township, zipcode, county
        * */
        SOMERVILLE("Somerville", "08876", "Somerset"),
        /**
        * Contains the location for the Somerville gym: township, zipcode, county
        * */
        EDISON("Edison", "08837", "Middlesex"),
        /**
        * Contains the location for the Edison gym: township, zipcode, county
        * */
        PISCATAWAY("Piscataway", "08854", "Middlesex"),
        /**
        * Contains the location for the Piscataway gym: township, zipcode, county
        * */
        FRANKLIN("Franklin", "08873", "Somerset");
        /**
        * Contains the location for the Franklin gym: township, zipcode, county
        * */


        private final String township;

        private final String zipcode;

        private final String county;


        /**
        * Helper method that creates an instance of each variable: township, zipcode, county
        * Used throughout course of the file
         * @param township
         * @param county
         * @param zipcode
        * */
        private Location(String township, String zipcode, String county) {

            this.township = township;

            this.zipcode = zipcode;

            this.county = county;

        }

        /**
        * getter for zipcode
         * @return String
        * */
        String getZipcode() {
            return zipcode;


        }

        /**
         * getter for township
         * @return String
        * */
        String getTownship() {
            return township;


        }

        /**
         * getter for county
         * @return String
         * */
        String getCounty() {
            return county;

        }

        /**
         * Returns of a string of location, formatted to print properly
         * @return String
         * */
        @Override
        public String toString() {
            return township.toUpperCase() + ", " + zipcode.toUpperCase() + ", " + county.toUpperCase();
        }


    }
