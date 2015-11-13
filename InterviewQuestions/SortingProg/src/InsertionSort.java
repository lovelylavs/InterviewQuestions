/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lavanya
 */
public class InsertionSort 
{
   static void  Insertion(int arr[], int n)
    {
        int i,j,v;
        for(i=2;i<=n-1;i++)
        {
            v=arr[i];
            j=i;
            
            while(arr[j-1]>v && j>=1)
            {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=v;
        }
        
    }
    public static void main(String[] args) 
    {
        int arr[] = {2,1,7,5,8};
        Insertion(arr,arr.length);
    }
}
 