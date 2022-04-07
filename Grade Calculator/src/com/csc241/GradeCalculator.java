
package com.csc241;

import java.util.Arrays;


public class GradeCalculator
{
  public static double avg( final double[] grades )
  {
      double total = 0;
    
      total = Arrays.stream(grades).sum();
      
      return total / grades.length;
  }
	
  public static double avg( final Student[] students )
  {
     double avg = 0;
     double[] grades;
     int totalNumberOfGrades = 0; 

      for (Student student : students) {
          grades = student.getGrades();
          // Get the grades array for student and store in the intermediate variable grades.
          totalNumberOfGrades = grades.length + totalNumberOfGrades;
          
          // Add grades.length to totalNumberOfGrades.
          for(int j = 0; j<grades.length; j++ )
              
          {
              avg = grades[j] + avg;
              // Keep accumulating grade in avg.
              
          }       
      }

    return avg/totalNumberOfGrades;
    
  }
	
  public static MaxMin maxMin( final double[] grades )
  {
      double max = 0;
      double min = grades[0];
      
      
      for(int i=0; i<grades.length; i++){
          if(grades[i]>max){
              max = grades[i];
          }
          
      }
      for(int i=0; i<grades.length; i++){
          if(grades[i]<min){
              min = grades[i];
          }
          
      }
      MaxMin maxmin = new MaxMin();
      
      maxmin.setMax(max);
      maxmin.setMin(min);
      return maxmin;
      
  }
	
  public static MaxMin maxMin( final Student[] students )
  {
      
     double max = 0;
     double min = 200;
     double[] grades;
      
      for(int i=0; i<students.length; i++){
         grades = students[i].getGrades();
          for(int j=0; j<grades.length; j++){
              if(grades[j]>max){
              max = grades[j];
          }
          }
          
          
      }
      for(int i=0; i<students.length; i++){
         grades = students[i].getGrades();
          for(int j=0; j<grades.length; j++){
              if(grades[j]<min){
              min = grades[j];
          }
          }
          
          
      }
   
      MaxMin maxmin = new MaxMin();
      
      maxmin.setMax(max);
      maxmin.setMin(min);
      return maxmin;
 
   }
      
}
