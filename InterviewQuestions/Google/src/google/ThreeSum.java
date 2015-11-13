/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class ThreeSum {
    
    public static void main(String[] args)
    {
        int[] S = {-1, 0, 1, 2, -1, -4};
        
        threeSum(S);
        
    }
    
     public static List<List<Integer>> threeSum(int[] nums) {
        
         

         List<List<Integer>> totList = new ArrayList<>();
       
         if(nums.length < 3)
            return totList;
         
         Arrays.sort(nums);
         int len = nums.length;
         for(int i=0; i<nums.length -2; i++)
         {
             if(i==0  || nums[i] > nums[i-1] )
             {
                 int negate=-nums[i];
                 
                 int start = i+1;
                 int end = len-1;
                 
                 while(start <end)
                 {
                     if(nums[start] +nums[end] ==negate)
                     {
                         ArrayList<Integer> temp = new ArrayList<Integer>();
                         temp.add(nums[i]);
                         temp.add(nums[start]);
                         temp.add(nums[end]);
                         
                         totList.add(temp);
                         
                         start++;
                         end--;
                         
                         while(start < end && nums[end] == nums[end+1])
                              end--;
                         
                         while(start < end && nums[start] == nums[start-1])
                              start++;
                     }
                     else if(nums[start]+nums[end] <negate)
                     {
                         start++;
                     }
                     else
                     {
                         end--;
                     }
                 }
             }
            
         }
         return totList;
    }
}
