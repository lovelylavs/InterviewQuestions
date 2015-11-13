/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primefactors;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class PrimeFactors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num =14;
       
        System.out.println(isUgly(num));
        System.out.println(countPrimes(num));
        primeFactors(num);
        
    }
    public static boolean isUgly(int num)
    {
        if(num==1) return true;
        if(num==0) return false;
        
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }
    public static List<Integer> primeFactors(int number)
    {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for(int i=2; i<=n;i++)
        {
            while(n%i==0)
            {
                factors.add(i);
                n/=i;
            }
        }
        System.out.println(factors.size());
        return factors;
    }
    public static int countPrimes1(int n) {
        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
         if (!used[i - 1]) {
            int temp = i * i;
            while (temp < n) {
                used[temp - 1] = true;
                temp += i;
            }
        }
        }
        for (int i = 2; i < n; i++) {
        if (!used[i - 1]) {
            res++;
        }
        }
        return res;
    }
    
    public static int countPrimes(int n) {
	if (n <= 2)
		return 0;
 
	// init an array to track prime numbers
	boolean[] primes = new boolean[n];
	for (int i = 2; i < n; i++)
		primes[i] = true;
 
	for (int i = 2; i <= Math.sqrt(n - 1); i++) {
	// or for (int i = 2; i <= n-1; i++) {
		if (primes[i]) {
			for (int j = i + i; j < n; j += i)
				primes[j] = false;
		}
	}
 
	int count = 0;
	for (int i = 2; i < n; i++) {
		if (primes[i])
			count++;
	}
 
	return count;
}
    
}
