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
public class Permutation 
{
    public static void main(String[] args)
    {
        int[] A = { 4, 1, 3 , 2};
        int N = 4;
        System.out.println(solution(A, N));
    }
    public static int solution(int A[], int N) {
    // write your code in C99
    int[] counter = new int[A.length];
 
        for(int i= 0; i< A.length; i++){
            if (A[i] < 1 || A[i] > A.length) {
                // Out of range
                return 0;
            }
            else if(counter[A[i]-1] == 1) {
                // met before
                return 0;
            }
            else {
                // first time meet
                counter[A[i]-1] = 1;
            }
        }
        return 1;
    }

}
