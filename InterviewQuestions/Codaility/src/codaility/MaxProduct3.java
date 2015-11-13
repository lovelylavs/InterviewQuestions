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
public class MaxProduct3 {
    
      public static void main(String[] args)
    {
        int[] A = { -100000, -35678, -65575, -45657, -46661, 26666};
        System.out.println(solution(A));
    }
      
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        for(int i=0; i< n ;i++)
            System.out.println(A[i]);
        return Math.max(A[0]*A[1]*A[n-1], A[n-1]*A[n-2]*A[n-3]);
    }
}
