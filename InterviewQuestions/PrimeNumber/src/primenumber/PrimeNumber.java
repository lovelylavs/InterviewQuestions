/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primenumber;

/**
 *
 * @author Lavanya
 */
public class PrimeNumber {

    /**
     * @param args the command line arguments
     */
    boolean isPrime(int n) {
    //check if n is a multiple of 2
    if (n%2==0) return false;
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0)
            return false;
    }
    return true;
}
    
    public static void main(String[] args) {
        // TODO code application logic here
    PrimeNumber m = new PrimeNumber();
        System.out.println(m.isPrime(121));
    }
    
}
