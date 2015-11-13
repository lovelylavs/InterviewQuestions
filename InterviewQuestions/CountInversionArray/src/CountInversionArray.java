/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lavanya
 */
/*Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).*/

public class CountInversionArray 

{
    int getEnvCount(int[] arr, int n)
    {
        int invCount = 0;
        int iValue,jValue;
        
        for(iValue=0;iValue<n-1;iValue++)
            for(jValue=iValue+1; jValue<n; jValue++)
                if(arr[iValue]>arr[jValue])
                    invCount++;
        return invCount;
    }
    public static void main(String[] args)
    {
        int arr[] = {2,4,1,3,5};
        CountInversionArray myVar = new CountInversionArray();
        System.out.println("The inversion count of array is"+myVar.getEnvCount(arr, arr.length));
    }
}
