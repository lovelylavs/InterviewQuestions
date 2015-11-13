/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lavanya
 */
public class MinPositiveMiss {
    
     public static void main(String[] args)
    {
        int[] A = { 1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }
     
     public static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        
        int num=1;
        for(int i=0 ; i< A.length; i++)
        {
             set.add(A[i]);
             
             //This loop makes sure that num is increases until all elements in set
             while(set.contains(num))
                 num++;
        }
               
       
        return num;              
    }
}
