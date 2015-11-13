/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.math.BigInteger;

/**
 *
 * @author Lavanya
 */
public class ProductsExlude {
    
    public static void main(String[] args) throws Exception{
        int[] a = {9,3,4,8};
        BigInteger[] r = new BigInteger[a.length];
        int x = 1;
        r[0] = BigInteger.ONE;
        for (int i=1;i<a.length;i++){
            r[i]=r[i-1].multiply(BigInteger.valueOf(a[i-1]));
        }
        for (int i=a.length-1;i>0;i--){
            x=x*a[i];
            r[i-1]=BigInteger.valueOf(x).multiply(r[i-1]);
        }
        for (BigInteger r1 : r) {
            System.out.println(r1);
        }
        
    }
   
    
}
