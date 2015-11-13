/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayduplicates;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Lavanya
 */
public class ArrayDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {0};
        System.out.println(containsDuplicate(nums));
    }
    
    public static boolean containsDuplicate(int[] nums) 
    {
        if(nums.length==0)
            return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
            {
                map.put(nums[i], map.get(nums[i])+1);
                return true;
            }
           
        }
         return false;
    }
    
    public boolean containsDuplicate1(int[] nums) {
    if(nums==null || nums.length==0)
        return false;
 
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i: nums){
        if(!set.add(i)){
            return true;
        }
    }
 
    return false;
}
}
