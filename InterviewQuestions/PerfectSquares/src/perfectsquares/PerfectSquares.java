/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perfectsquares;

/**
 *
 * @author Lavanya
 */
public class PerfectSquares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = numSquares(12);
        System.out.println(x);
    }
     public static int numSquares(int n) {
        int[] table = new int[n+1];
    double max = Math.floor(Math.sqrt(n));

int max1 = (int)max;
    int squared;

    for (int i=0; i<=n; i++){
        table[i] = i;
    }
    for (int i=2; i<=max1; i++){
        for (int j=0; j<=n; j++){
            squared = (int)Math.pow(i,2);
            if (squared <= j)
                table[j] = Math.min(table[j], table[j-squared]+1);
        }
    }
    return table[n];
    }
}
