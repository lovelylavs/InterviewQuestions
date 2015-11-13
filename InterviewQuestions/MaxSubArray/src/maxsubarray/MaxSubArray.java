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
public class MaxSubArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumArray(arr));
    }
    
    public static int maxSumArray(int[] arr)
    {
        
        int maxSum=arr[0],newSum=arr[0];
        int[] sum = new int[arr.length];
        for(int i=1; i< arr.length; i++)
        {
             sum[i] = Math.max(sum[i-1]+arr[i],arr[i]);
            
             maxSum = Math.max(sum[i], maxSum);
            
        }
        return maxSum;
    }
}
