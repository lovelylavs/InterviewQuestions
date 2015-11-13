/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maxsubarray;

/**
 *
 * @author Lavanya
 */
public class MaxProArray {
    
     public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
     
     public static int maxProduct(int[] nums) {
        
        if(nums.length ==0)
           return 0;
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int product = nums[0];
        
        for(int i=1; i < nums.length; i++){
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(nums[i]*maxProduct,nums[i]),nums[i]*minProduct);
            minProduct = Math.min(Math.min(nums[i]*temp,nums[i]),nums[i]*minProduct);
            product = Math.max(product,maxProduct);
        }
        
        return product;
    }
}
