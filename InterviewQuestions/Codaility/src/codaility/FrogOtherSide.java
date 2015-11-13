/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

import java.util.HashSet;

/**
 *
 * @author Lavanya
 */
public class FrogOtherSide {
    
    public static void main(String[] args)
    {
        int[] A = {1, 3, 1, 4, 2, 3, 5 ,4};
        int X = 5;
        System.out.println(solution(X, A));
    }
    
    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int i = 0 ; i < A.length; i++) {
            if (A[i] <= X)
               hset.add(A[i]);   
            if (hset.size() == X)
               return i;
        }

        return -1;

    }
}
