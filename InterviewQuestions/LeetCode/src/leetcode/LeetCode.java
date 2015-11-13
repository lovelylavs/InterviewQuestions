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
public class LeetCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums={8,9,5,2,2,56,2};
        System.out.println(findDuplicate(nums));
    }
    
    //There is only one duplicate that can occcur. It occurs multiple times too
    public static int findDuplicate(int[] nums) {
        if(nums != null && nums.length > 1)
        {
            int slow=nums[0];
            int fast=nums[2];
            
                while(slow != fast)
                {
                    slow=nums[slow];
                    fast=nums[nums[fast]];
                }
                fast=0;
                while(fast != slow)
                {
                    slow=nums[slow];
                    fast=nums[fast];
                }
                return slow;
            }
            
        return -1;
           
    }
}
