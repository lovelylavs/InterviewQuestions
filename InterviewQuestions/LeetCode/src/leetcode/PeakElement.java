/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 *
 * @author Lavanya
 */
public class PeakElement {

    public static void main(String[] args){
        int nums[]= {3,2,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakHelper(int[] nums, int left, int right, int len){
        
        //Find index of the middle element
        int middle = left+(right-left)/2;
        
        //Compare the middle element with neighbors if they exist
        if((middle ==0 || nums[middle-1] <=nums[middle]) && 
                (middle==len-1 || nums[middle+1]<=nums[middle]))
            return middle;
        
        //if middle element is not peak and left neighbor greater than it
        //left half must have peak element
        else if(middle>0 && nums[middle-1]>nums[middle])
            return findPeakHelper(nums,left,(middle-1),len);
        
        //If middle element is not the peak and the right neighbor is greater than it
        //right half must have peak element
        else
            return findPeakHelper(nums,(middle+1),right,len);
    }
    public static int findPeakElement(int[] nums){
        int len = nums.length;
        return findPeakHelper(nums,0,len-1,len);    
    }
}
