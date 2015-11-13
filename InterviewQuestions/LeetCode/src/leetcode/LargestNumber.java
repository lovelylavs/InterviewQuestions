/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Lavanya
 */
public class LargestNumber {
    
     public static void main(String[] args){
        int nums[]= {3,30,34,5,9};
        
        System.out.println(largestNumber(nums));
    }
     public static String largestNumber(int[] nums) {
        
        String[] str = new String[nums.length];
        
        for(int i=0; i<nums.length ; i++){
            str[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1,String s2){
                String leftRight = s1+s2;
                String rightLeft = s2+s1;
                return -leftRight.compareTo(rightLeft);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String s:str){
            sb.append(s);
        }
        
        while(sb.charAt(0)=='0'&&sb.length()>1){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
