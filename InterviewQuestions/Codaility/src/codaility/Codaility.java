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
public class Codaility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A={ 3,1, 2, 4, 3};
        int[] b={ 11,4,17,18};
        System.out.println(minCom(A, b));
        System.out.println(solution(A));
    }
    
    public static int minCom(int A[], int B[])
    {
        Set<Integer> s = new HashSet<Integer>();
        
        for(int i=0; i<A.length ;i++)
        {
            s.add(A[i]);
        }
        
        int commonMin=Integer.MAX_VALUE;
        for(int i=0; i< B.length; i++)
        {
            if(s.contains(B[i]))
            {
                if(B[i] < commonMin)
                    commonMin=A[i];
            }
        }
        return commonMin;
    }
    
    //TapeEquilibrium
    public static int solution(int[] A) {
        // write your code in Java SE 8
        
        //First element
        int lsum = A[0];
        int rsum=0;
        int P=1;
            
        for(int k=P; k< A.length; k++)
        {
            rsum+=A[k];
        }
        
        int diff = Math.abs(lsum - rsum);
        
        for(; P < A.length-1; P++)
        {
            //Increase the sum
            lsum+=A[P];
            
            //Decrease the sum
            rsum-=A[P];
            
            //check the absolute difference
            int newDiff = Math.abs(lsum - rsum);
            if(newDiff < diff)
                diff  = newDiff;
        }
     
        return diff;
    }
}
