/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Lavanya
 */
/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class SingleNumber3 {
    
     public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={1, 1, 1, 3, 3, 3,2};
        int[] a = singleNumber(nums);
        
        for(int i=0; i< a.length; i++)
        {
            System.out.println(a[i]);
        }
         System.out.println(singleNumber2(nums));
    }
     
    public static int[] singleNumber(int[] nums) {
     HashSet<Integer> set= new HashSet<Integer>();
        for(int n: nums)
        {
            if(!set.add(n))
                set.remove(n);
        }
        
        int[] newArr = new int[set.size()];
        int ct=0;
        for(int i: set)
        {
            newArr[ct++]=i;
        }
        
        return newArr;
    
    }
    
    public static int singleNumber2(int[] nums) {
     HashSet<Integer> set= new HashSet<Integer>();
     int c = 0;
        for(int n: nums)
        {
            if(!set.contains(n))
                c=n;
        }
        
        
        
        return c;
    
    }
}
