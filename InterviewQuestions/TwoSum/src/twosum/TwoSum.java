/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twosum;

import java.util.HashMap;

/**
 *
 * @author Lavanya
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int nums[] = {2,7,11,15};
        int target= 100;
        int[] index = twoSumBet(nums, target);
        System.out.println("index" + index[0] + index[1]);
    }
    
    public static int[] twoSum(int[] nums, int target)
    {
        int[] index = new int[2];
        for(int i=0; i< nums.length; i++)
        {
            for(int j=i; j < nums.length -1 ; j++)
            {
                if((nums[i] + nums[j]) == target)
                {
                    index[0]=i + 1;
                    index[1]=j + 1;
                }
            }
        }
        return index;
    }
    
    //{2, 7, 11, 15}  9
    public static int[] twoSumBet(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        int[] result = new int[2];
        
        for(int i=0; i< nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                int index = map.get(nums[i]);
                result[0] = index + 1;
                result[1]= i+1;
                break;
                        
            }
            else
            {
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}
