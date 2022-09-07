package Action_Item;

import java.util.ArrayList;

public class Automation_AI02 {
    public static void main(String[] args) {

        //declare the conditional variables
        int grade = 90;

        if (grade >= 90 && grade <= 100) {
            System.out.println("print grade as a");
        } else if (grade >= 80 && grade < 90 ) {
            System.out.println("print grade as b");
        } else if (grade > 70 && grade < 80 ) {
            System.out.println("print grade as c");
        } else if (grade >= 60 && grade < 70) {
            System.out.println("print grade as d");
        } else {
            System.out.println("print grade as f");
        }


        int grade2 = 80;
        if (grade2 >= 90 && grade2 <= 100) {
            System.out.println("print grade as a");
        } else if (grade2 >= 80 && grade2 <= 90) {
            System.out.println("print grade as B");
        } else if (grade2 >= 70 && grade2 <= 80) {
            System.out.println("print grade as C");
        } else if (grade2 >= 60 && grade2 <= 70) {
            System.out.println(" print grade as D");
        } else {
            System.out.println("print grade as F");
        }


        //create an arraylist
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten");

        //using for loop to iterate through the values
        for (int i = 0; i < cities.size(); i++) {

            // //using if statement
            // if (cities.get(i)=="Brooklyn") {
            //     System.out.println("City is " + cities.get(i));
            // } else if (cities.get(i)=="Manhattan") {
            //     System.out.println("City is " + cities.get(i));
            // }


            // now using and operater
            if (cities.get(i)=="Brooklyn" || cities.get(i)=="Manhattan") {
                System.out.println("My city is " + cities.get(i));
            }

        }//end of loop
    }//end of main
}//end of class
