/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class LongestIncreasing {
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={ 2, 5, 3, 7, 11, 8, 10, 13, 6};
        System.out.println(lengthOfLIS(nums));
    }
    
    public static int endIndex(int[] nums,int left, int right, int val){
        
        while(right - left >1){
            int middle = left + (right - left)/2;
            if(nums[middle]>=val)
                right = middle;
            else
                left=middle;
        }
        return right;
    }
     public static int lengthOfLIS(int[] nums) {

         if(nums.length ==0)
            return 0;
         int[] endElArray = new int[nums.length];
         int len=1;
         
         endElArray[0]=nums[0];
         
         for(int i=1; i< nums.length;i++){
             
             //Find the new smallest element
             if(nums[i]<endElArray[0]){
                 endElArray[0]=nums[i];
             }
             
             //find an element greater we extend largest subsequence by nums[i]
             else if(nums[i]>endElArray[len-1]){
                 endElArray[len++]=nums[i];
             }
             else{
                 //We have found a new element at the end
                 endElArray[endIndex(endElArray,-1,len-1,nums[i])]=nums[i];
             }
       }
        
        
        return len;
    }
}
