
package com.csc241;

import java.util.*;

/**
 *
 * @author coltin
 */

public class Lab01 {

    
    public static void main(String[] args) {
        
        GradeCalculator GC = new GradeCalculator();
        MaxMin maxmin = new MaxMin();
        int numStudents = 0;
        int nGrds = 0;
        String fName;
        String lname;
        Scanner scan = new Scanner(System.in);
        String an;
        char decision;
        
        do{
        
        System.out.println("How many students are in your class?");
        
        numStudents = scan.nextInt();
        
        Student[] student = new Student[numStudents];
        
        
        
        for(int i = 0; i < numStudents; i++){
            
             student[i] = new Student();
            
            System.out.println("Enter the first name of student #" + (i+1));
            
            fName = scan.next();
             
             student[i].setFName(fName);

            System.out.println("Enter " + fName + "'s last name!");

            lname = scan.next();
            
             student[i].setLName(lname);

            System.out.println("How many grades will you be entering for " + fName + " " + lname + "?");

            nGrds = scan.nextInt();
            
            double[] grades = new double[nGrds];

            System.out.println("Please enter the grades for " + fName + " " + lname);

           

            for(int j=0; j<nGrds; j++){
                double sumGrds = 0;
                grades[j] = scan.nextDouble();
                sumGrds = sumGrds + grades[j];
                
            }
            student[i].setGrades(grades);
            
            System.out.println("Grade statistics for " + fName + " " + lname + " (average=" + GC.avg(grades) + " ; max/min=" + GC.maxMin(grades).getMax()
             + "/" + GC.maxMin(grades).getMin() + ")");
            
            
            
        }
            System.out.println("Ensemble Statistics: - Average = " + GC.avg(student) + " ; Max/Min = " + GC.maxMin(student).getMax() + "/" + GC.maxMin(student).getMin() + ")");
            
            System.out.println("Would you like to continue? (Y/N)");
            
            an = scan.next();
            
            decision = an.charAt(0);
            
            }while(decision=='Y' || decision=='y');
        
        
        
    }
    
}
