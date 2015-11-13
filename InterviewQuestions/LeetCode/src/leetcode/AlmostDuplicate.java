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
public class AlmostDuplicate {
     public static void main(String[] args){
        int nums[]= {-1,-1};
        
        System.out.println(containsNearbyAlmostDuplicate(nums,1,0));
    }
    
     public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        int i = 0;  
        int j = 1;
        int size=nums.length;
        // Search for a pair
        while (i<size && j<size)
        {
            if (i != j && nums[j]-nums[i] == k && i-j == t)
            {
                return true;
            }
            else if (nums[j]-nums[i] < k && i-j <=t)
                j++;
            else
                i++;
        }
        return false;
    }
}
