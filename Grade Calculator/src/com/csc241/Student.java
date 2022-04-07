
package com.csc241;

public class Student
{
  private double[] grades;

  private String fName;
  private String lName;

  public double[] getGrades()
  {
    return grades;
  }

  public void setFName( final String fName )
  {
    this.fName = fName;
  }

  public void setGrades( final double[] grades )
  {
    this.grades = grades;
  }

  public void setLName( final String lName )
  {
    this.lName = lName;
  }  
}
