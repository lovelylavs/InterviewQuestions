/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

/**
 *
 * @author Lavanya
 */
public class DivisibleByK {
    
     public static void main(String[] args)
    {
        
        System.out.println(solution(6,11,2));
    }
    
    public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int D = B - A + 1;
        return D / K + ((B % K) < (D % K) ? 1 : 0);
    }
}
