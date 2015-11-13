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
public class MergeSort {
    
    public static void main(String[] args)
    {
        int[] inputArr = {45,23,11,89,77,98,4};
        int[] b = sort(inputArr);
        for (int i : b)
        {
                System.out.println(i);
        }
    }
  
     public static int[] sort(int[] array){
        mergeSort(array, 0, array.length - 1);
        return array;
    }
     
    public static void mergeSort(int[] nums, int start, int end)
    {
        if(start < end)
        {
            int mid = (start+end)/2;
            mergeSort(nums,0,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
        
        
        
    }
    
    public static void merge(int[] nums, int start, int mid, int end)
    {
        int n1 = mid-start+1;
        int n2= end-mid;
        int[] left = new int[n1+1];
        int[] right = new int[n2+1];
        

        for(int i=0; i< n1; i++)
        {
            left[i]=nums[start+i];
        }
        for(int j=0; j< n2; j++)
        {
            right[j]=nums[mid+j+1];
        }
        
        left[n1]=Integer.MAX_VALUE;
        right[n2]=Integer.MAX_VALUE;

        
        for(int i = 0,  j = 0,  k = start; k <= end; k++){
            if(left[i] <= right[j]){
                nums[k] = left[i++];
            }else{
                nums[k] = right[j++];
            }
        }
        
        
    }
}
