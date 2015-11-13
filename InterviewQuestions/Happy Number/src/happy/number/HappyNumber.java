/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package happy.number;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lavanya
 */
public class HappyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HappyNumber happy = new HappyNumber();
        System.out.println(happy.happyNumber(19));
        System.out.println(isHappy(19));
    }
    
    public boolean happyNumber(int number)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(!set.contains(number))
        {
            set.add(number);
            number = sum(getDigits(number));
            if(number==1)
                return true;
        }
        return false;
    }
    
    public int sum(int[] arrNum)
    {
        int sum=0;
        for(int rem: arrNum)
        {
            sum+=(rem*rem);
        }
        return sum;
    }
    
    public int[] getDigits(int n)
    {
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int i=0;
        
        while(n>0)
        {
            int m = n%10;
            result[i++]=m;
            n=n/10;
        }
        
        return result;
    }
    
    public static boolean isHappy(int number)
    {
        Set<Integer> unique = new HashSet<Integer>();

        //Add the elements to unique set to see that we are not looping
        while (unique.add(number))
        {
            int value = 0;
            while (number > 0)
            {
                //Extract each digit and calculate sum of sqaures
                value += Math.pow(number % 10, 2);
                number /= 10;
            }
            
            number = value;
        }

        return number == 1;
    }
}
