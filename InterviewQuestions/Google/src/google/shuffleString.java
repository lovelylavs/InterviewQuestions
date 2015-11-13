/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

/**
 *
 * @author Lavanya
 */
public class shuffleString {
 
    public static void main(String[] args)
    {
        System.out.println(shuffleString("hallooween"));
        System.out.println("google".substring(0));
        System.out.println("google".substring(2,3));
    }
    public static String shuffleString(String str)
    {
        for(int i=1; i< str.length()-1; i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
            {
                return str.substring(0,i-1)+shuffleString(str.substring(i))+str.substring(i-1,i);
            }
        }
        return str;
    }
}
