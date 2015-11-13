/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leapyear;

/**
 *
 * @author Lavanya
 */
public class LeapYear 
{
    boolean isLeapYear(int year)
    {
        if((year%4==0 && year%100!=0 || year%400 ==0))
        {
            return true;
        }
        else
            return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LeapYear leap = new LeapYear();
        System.out.println(leap.isLeapYear(1900));
    }
    
}
