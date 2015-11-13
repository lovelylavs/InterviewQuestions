/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demostudy;

import java.util.Arrays;

/**
 *
 * @author Lavanya
 */
public class DemoStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int result = -13 % -6; 
        System.out.println(1/0.0);
         System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
         
         char[] chars = new char[] {'\u0097'}; 
         String str = new String(chars);
         byte[] bytes = str.getBytes(); 
         System.out.println(Arrays.toString(bytes));

    }
    
}
