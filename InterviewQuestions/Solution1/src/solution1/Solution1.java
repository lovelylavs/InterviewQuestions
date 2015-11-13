/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution1;

/**
 *
 * @author Lavanya
 */
public class Solution1 {

    /**
     * @param args the command line arguments
     */
    public void moveZeroes(int[] nums) {
        
        int x = 0;
        
        //Traverse through the array and move elements which are non zero to the left
        for(int j=0; j<nums.length; j++)
            {
                if(nums[j]!=0)
                {               
                    nums[x++]=nums[j];
                }
            }
        
        //The values after i are all zeroes.
        while(x<nums.length)
            nums[x++]=0;
        for(int ii=0; ii< nums.length;ii++)
            System.out.println(nums[ii]);    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr= {0,1,0,3,12};
        Solution1 sol = new Solution1();
        sol.moveZeroes(arr);
        
    }
    
}
