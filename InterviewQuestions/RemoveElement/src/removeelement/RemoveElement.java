/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package removeelement;

import java.util.ArrayList;

/**
 *
 * @author Lavanya
 */
public class RemoveElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x[] = {4,5};
        System.out.println(removeElement(x, 4));
    }
 
     public static int removeElement(int[] nums, int val) {
        int count=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i< nums.length; i++)
        {
            if(nums[i] == val)
            {
                count++;
            }
            else
            {
                list.add(nums[i]);
            }
        }
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)  
        ret[i++] = e.intValue();
        
        return ret.length;
    }
}
