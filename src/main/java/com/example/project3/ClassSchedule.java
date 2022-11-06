package com.example.project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/***
 * Imports class schedule from ClassSchedule.txt
 * @author Reiya Dave, Ifrah Sajjad
 */

public class ClassSchedule{
    private FitnessClass[] classes;
    private int numClasses;

    /***
     * constructor created for class schedule class
     * */
    public ClassSchedule(){
        this.classes = new FitnessClass[15];
        this.numClasses = 0;
    }

    /***
     * getter for number of classes
     * */
    public int getNumClasses(){
        return numClasses;
    }

    /***
     * getter for fitness class
     * */
    public FitnessClass[] getFitnessClass(){
        return classes;
    }

    /***
     * find method to look for a specific fitness class
     * @param fitnessClass
     * @return int
     * */
    public int find(FitnessClass fitnessClass){
        int result = -1;
        for(int i = 0; i < this.numClasses; i++){
            if (classes[i].getClassName().toLowerCase().equals(fitnessClass.getClassName().toLowerCase()) && classes[i].getInstructor().toLowerCase().equals(fitnessClass.getInstructor().toLowerCase()) && classes[i].getClassLocation().getTownship().toLowerCase().equals(fitnessClass.getClassLocation().getTownship().toLowerCase())){
                result = i;
                return result;
            }
        }
        //to check which one is not correct- classname, instructor, or location

        //classname
        for (int i = 0; i < this.numClasses; i++){
            if (classes[i].getClassName().toLowerCase().equals(fitnessClass.getClassName().toLowerCase())){
                break;
            }
            if (i == numClasses-1){
                result = -2;
                return result;
            }
        }

        //instructor
        for (int i = 0; i < this.numClasses; i++){
            if (classes[i].getInstructor().toLowerCase().equals(fitnessClass.getInstructor().toLowerCase())){
                break;
            }
            if (i == numClasses-1){
                result = -3;
                return result;
            }
        }

        //location
        for (int i = 0; i < this.numClasses; i++){
            if (classes[i].getClassLocation().getCounty().toLowerCase().equals(fitnessClass.getClassLocation().getCounty().toLowerCase())){
                break;
            }
            if (i == numClasses-1){
                result = -4;
                return result;
            }
        }

        return result;
    }


    /***
     * method that will read in classSchedule.txt file through the use of scanner
     * */
    public String readFile(){
        try{
            File file = new File("gym/classSchedule.txt"); //change back

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                //parse each line as a new fitness class
                FitnessClass fitnessClass = new FitnessClass();
                String readLine = sc.nextLine();
                StringTokenizer token = new StringTokenizer(readLine, " ");
                fitnessClass.setClassName(token.nextToken());
                fitnessClass.setInstructor(token.nextToken());
                String timeslot = token.nextToken();
                if (timeslot.toLowerCase().equals("morning")){
                    fitnessClass.setClassTime(Time.MORNING);
                }
                else if (timeslot.toLowerCase().equals("afternoon")){
                    fitnessClass.setClassTime(Time.AFTERNOON);
                }
                else if (timeslot.toLowerCase().equals("evening")){
                    fitnessClass.setClassTime(Time.EVENING);
                }

                String loc = token.nextToken();
                if (loc.toLowerCase().equals("bridgewater")){
                    fitnessClass.setClassLocation(Location.BRIDGEWATER);
                }
                else if (loc.toLowerCase().equals("edison")){
                    fitnessClass.setClassLocation(Location.EDISON);
                }
                else if (loc.toLowerCase().equals("piscataway")){
                    fitnessClass.setClassLocation(Location.PISCATAWAY);
                }
                else if (loc.toLowerCase().equals("somerville")){
                    fitnessClass.setClassLocation(Location.SOMERVILLE);
                }
                else if (loc.toLowerCase().equals("franklin")){
                    fitnessClass.setClassLocation(Location.FRANKLIN);
                }
                classes[numClasses] = fitnessClass;
                numClasses++;

            }
            //System.out.println("Fitness Classes Loaded.");
            String result = "Fitness Classes Loaded.";
            sc.close();
            return result;
        }
        catch (FileNotFoundException e){
            //System.out.println("File does not exist.");
            String result = "File does not exist.";
            e.printStackTrace();
            return result;
        }
    }


}
