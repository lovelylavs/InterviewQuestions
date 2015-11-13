/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortedduplicates;

/**
 *
 * @author Lavanya
 */
public class SortedDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums= {1,1,1,2,2,3};
        removeDuplicates(nums);
    }
    
    /*Remove Duplicates: Your function should return length = 5,
    with the first five elements of nums being 
    1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
    */
    
    public static int removeDuplicates(int[] nums)
    {
        //1 1 1 2 2 3 3 4 4 4
        if(nums.length <=2)
            return nums.length;
        
        int prev =1;
        int cur = 2;
        
        while(cur < nums.length)
        {
            if(nums[cur] == nums[prev] && nums[cur] == nums[prev-1])
            {
                cur++;
            }
            else
            {
                prev++;
                nums[prev] = nums[cur];
                cur++;
            }
        }
        return prev+1;
    }
    
}
