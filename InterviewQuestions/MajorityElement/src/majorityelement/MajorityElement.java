/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package majorityelement;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Lavanya
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int majo[] = {2,3,4,4,5,5,6,6,6,6};
        System.out.println(majorityElement(majo));
        System.out.println(majorityElement1(majo));
           System.out.println(majorityElemen(majo));
    }
    public static int majorityElement(int[] nums) {
       

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
                
            }
           
        }
        Entry<Integer,Integer> maxEntry = null;

        for(Entry<Integer,Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
        
        
    }
    
    public static int majorityElement1(int[] num) {
	if (num.length == 1) {
		return num[0];
	}
 
	Arrays.sort(num);
	return num[num.length / 2];
}
    
    public static int majorityElemen(int[] nums) {
    int result = 0, count = 0;
 
    for(int i = 0; i<nums.length; i++ ) {
        if(count == 0){
            result = nums[ i ];
            count = 1;
        }else if(result == nums[i]){
           count++;
        }else{
           count--;
        }
    }
 
    return result;
}
}
