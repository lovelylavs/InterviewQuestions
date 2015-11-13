/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;
import java.util.*;
/**
 *
 * @author Lavanya
 */
public class Bday {
   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        for(int i=0; i<noOfTests; i++){
            int black = sc.nextInt();
            int white = sc.nextInt();
            
            int costB = sc.nextInt();
            int costW = sc.nextInt();
            int price=0;
            int costConversion = sc.nextInt();
            
            //If the cost of conversion from white to black is less than cost of black
            if((costW+costConversion)<=costB){
                price = (costW+costConversion)*black + (white*costW);
            }else if ((costB+costConversion) <= costW){
                //If the cost of conversion from black to white is less than cost of white
                price = ((costB + costConversion) * white) + (black*costB);
            }else{
                price = (costB * black) + (costW * white);
            }
            System.out.println(price);
        }
    } 
}
