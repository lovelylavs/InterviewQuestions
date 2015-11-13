/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 *
 * @author Lavanya
 */
public class ArrProExceptSelf {
    
    public static void main(String[] args){
        int[] inpArr = {1,2,3};
        int[] res = productArrExcSelf(inpArr);
        for(int a : res){
            System.out.println(a);
        }
    }
    public static int[] productArrExcSelf(int[] nums){
         int[] prods = new int[nums.length];
        prods[prods.length-1] = 1;

        for(int i=nums.length-2; i>=0; i--) {
            prods[i] = prods[i+1] * nums[i+1];
        }

        int left = 1;
        for(int i=0; i<nums.length; i++) {
            prods[i] *= left;
            left *= nums[i];
        }

        return prods;
    }
}
