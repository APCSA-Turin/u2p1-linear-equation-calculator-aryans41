package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
     
    /* These instance variables would represent the two coordinates in the following way: 
    (x1, y1) and (x2, y2) */
    private int x1; 
    private int x2; 
    private int y1; 
    private int y2; 

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.

    /* this object constructor has two String parameters for the two coordinates and extracts the integer 
    values of the instance variables using the Integer.parseInt() method and the String class methods */

    public LinearCalculator(String coordinate1, String coordinate2) {  // <--add 2 string parameters to this constructor
        this.x1 = Integer.parseInt(coordinate1.substring(1, coordinate1.indexOf(","))); 
        this.x2 = Integer.parseInt(coordinate2.substring(1, coordinate2.indexOf(","))); 
        this.y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(",") + 1, coordinate1.length() -1)); 
        this.y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(",") + 1, coordinate2.length() -1)); 
    }

    //METHODS
    //getters and setters for the 4 instance variables (8 methods total)
    
    // these getter methods return the value of the four instance variables
    public int getX1(){
        return x1; 
    }
    public int getY1(){
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2; 
    }

    // these void methods set the value of the instance variables to a new specified int
    public void setX1(int newVal){
        x1 = newVal;
    } 
    public void setY1(int newVal){
        y1 = newVal; 
    }
    public void setX2(int newVal){
        x2 = newVal; 
    }
    public void setY2(int newVal){
        y2 = newVal; 
    }

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    
    /* this method returns the distance between the two coordinates rounded to the nearest hundredth using
       the instance variables and some of the methids found in the math class like power and square root.
    */

    public double distance(){
        double xDifferenceSquared = Math.pow(x2 - x1, 2); 
        double yDifferenceSquared = Math.pow(y2 - y1, 2); 
        double distance = Math.sqrt(xDifferenceSquared + yDifferenceSquared);  
        distance = roundedToHundredth(distance); 
        return distance; 
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99

    /* this method returns and calculates the y-intercept of the equation of the linear line 
    between the two coordinates (accounting for unfefined slope) with using the slope() method aka
    (nested methods) and using the equation y=mx+b to find that b=y-mx */
    public double yInt(){
        if (x2 - x1 == 0) { 
            return -999.99; 
        } // Undefined y intercept or verticle line
            double yIntercept = y1 - (slope() * x1); 
            return roundedToHundredth(yIntercept);  
        } 

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    
    /* this method calculates and returns the slope between the two coordinates or rate of change or rise over run.
       If the change x values is 0, it returns -999.99 (a vertical line). */
    public double slope(){
        double xDifference = x2 - x1; 
        double yDifference = y2 - y1; 
        double slope = yDifference / xDifference; 
        if (xDifference == 0) {
            return -999.99; 
        } else {
            return roundedToHundredth(slope);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method

    /* this method returns the string that represents the equation of the vertical line using the slope() 
    method and yInt() method. If slope is undefined(-999.99), it just prints undefined. If slope is 0 
    (horizontal  line), it just prints the y-intercept. If slope is any other, it would print the
    necessary equation of line. I used conditionals and nested methods to create this method. */

public String equation(){
    if (slope() == -999.99) {
            return "undefined"; 
    }
    if (slope() == 0.0) {
            return "y=" + yInt(); 
    }
    if (slope() > 0); 
    String output =  "y=" + slope() + "x"; 
    if (yInt() > 0) {
        output += "+" + yInt(); 
        } else if (yInt() == 0) {
                output = "y=" + slope() + "x";
        } else {
        output += yInt(); 
        } 
        return output; 
    } 
        
    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    // I used the math class method "round" to create a method that rounded a double value to nearest hundredth
    public double roundedToHundredth(double x) {
        return Math.round(x * 100.0) / 100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 

    /* this print method returns all the info between the two coordinates using the other methods in the 
    class and the instance variables */
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }
}