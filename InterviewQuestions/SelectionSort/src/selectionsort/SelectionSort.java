/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selectionsort;

/**
 *
 * @author Lavanya
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
     
    public static void SelectSort(int arr[], int n)
    {
        int i,j,min,temp;
        for(i=0;i<n-1;i++)
        {
            min=i;
            for(j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min])
                    min =j;
            }
            temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
    
    public static void main(String[] args) 
    {
        int arr[] = {2,1,7,5,8};
        SelectSort(arr,arr.length);
    }
    
}
