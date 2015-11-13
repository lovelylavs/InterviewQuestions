/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.*;
/**
 *
 * @author Lavanya
 */
public class LongestConsecutive {
     public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={ 100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    
    public static int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
        return 0;
        
        Set<Integer> set = new HashSet<>();
        int max=1;
        
        for(int n:nums)
           set.add(n);
         
        //for each n we check if consecutive elements appear in set. If present we remove them
        for(int n: nums){
            int left=n-1;
            int right = n+1;
            int count=1;
            
            //number than n
            while(set.contains(left)){
                count++;
                set.remove(left);
                left--;
            }
            
            //number greater than n
             while(set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            
            max=Math.max(count,max);
        }
        return max;
    }
}
