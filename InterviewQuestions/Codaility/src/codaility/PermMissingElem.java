/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

import java.util.Arrays;

/**
 *
 * @author Lavanya
 */
public class PermMissingElem {
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A={ 4, 7, 8, 5};
        System.out.println(permMissing100(A));

    }
    
    public static int permMissing(int[] A)
    {
        Arrays.sort(A);
        for(int i = 1 ; i <= A.length-1; i++)
        {
            if((A[i-1]+1) != A[i])
            {
                return (A[i-1]+1);
            }
        }
        return -1;
    }
    
     public static int permMissing100(int[] data)
    {
        long N = data.length+1;
        
        long total = (N * (N + 1)) /2;
        
        long sum=0L;
        
        for(int i: data)
        {
            sum+=i;
        }
        
        return (int)(total-sum);
    }
}
