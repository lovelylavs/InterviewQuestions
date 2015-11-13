/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

/**
 *
 * @author Lavanya
 */
public class Sorts {
 
    public static void main(String[] args)
    {
        int[] tmpArr = {3,9,2,61,8};
        int[] b = insertionSort(tmpArr);
        for(int i: b)
            System.out.println(i);
    }
    
    //Prints from highest to lowest
    public static int[] bubbleSort(int[] nums)
    {
        for(int i=1; i< nums.length; i++)
        {
            boolean is_sorted=true;
            for(int j=0; j<nums.length - i; j++)
            {
                if(nums[j] > nums[j+1])
                {
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    is_sorted = false;
                }
            }
            if(is_sorted) return nums;
        }
        return nums;
    }
    
    public static int[] insertionSort(int[] nums)
    {
        for(int i=1; i< nums.length; i++)
        {
            int temp = nums[i];
            int j;
            for(j=i-1; j>=0 && temp<nums[j];j--)
                nums[j+1]=nums[j];
            nums[j+1]=temp;
        }
        return nums;
    }
}
