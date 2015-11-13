/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class HackerRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        
        long first=sc.nextLong();
        long second=sc.nextLong();
        int n = sc.nextInt();
        long res=0L;
        int count = n-2;
        while(count>0){
            res+=second*second+first;
            first=second;
            second=res;
            res=0;
            count--;
        }
        System.out.println(res);
    }
    
}
