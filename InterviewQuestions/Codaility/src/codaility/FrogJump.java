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
public class FrogJump {
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A={ 4, 7, 8, 5};
        System.out.println(solution(10, 85, 30));

    }
    
   public static int solution(int X, int Y, int D) {
    // write your code in C99
       if((Y - X) %D ==0)
       {
           return (Y - X)/D;
       }
       
       return (Y - X) / D+1;
}
}
