/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adddigits;

/**
 *
 * @author Lavanya
 */
public class AddDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num =91;
        //System.out.println(addDigits(num));
        System.out.println(aDigits(num));
    }
    public static int addDigits(int n) {
        int sum=0;     
        while(n>9){
         int rem;
         rem=n%10; //Get the remainder of number modulo 10
         sum=sum+rem; //calculate the sum
         n=n/10; //divide the number by 10 to get the next place
         if(n<9) { //if the divided number less than 9 it means that there are no more digits
            sum+=n; //add the value to sum
            n=sum; //the new number is sum
            sum=0;
         }
        }
        
        System.out.println(n);
    return n;
    
    }
    
    /*https://en.wikipedia.org/wiki/Digital_root*/
    public static int aDigits(int n)
    {
        int sum=0;
        while(n>9)
        {
            int rem = n%10;
            sum = sum + rem;
            n = n/10;
            if(n<=9)
            {
                sum = sum+n;
                n=sum;
                sum=0;
            }
        }
        return n;
    }
}
