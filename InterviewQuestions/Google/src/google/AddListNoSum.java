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
public class AddListNoSum {
    
    public static void main(String[] args)
    {
        int arr[] = {500,100,800,900};
        System.out.println(listSum(arr));
    }
    
    public static int listSum(int[] arr)
    {
        int sum=0;
        for(int i=0; i<arr.length; i++)
        {
            while(arr[i] != 0)
            {
                int carry = sum & arr[i];
                
                sum^=arr[i];
                
                arr[i]=carry<<1;
            }
        }
        return sum;
    }
}
