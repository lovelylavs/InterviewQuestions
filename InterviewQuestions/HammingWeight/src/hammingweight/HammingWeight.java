/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hammingweight;

/**
 *
 * @author Lavanya
 */
public class HammingWeight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HammingWeight ham = new HammingWeight();
        System.out.println(ham.hammingWeight(2));
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
    }
    public int hammingWeight(int n) {
       
        int count=0;
        for(int i=1; i< 33; i++)
        {
            if(getBit(n,i)==true)
            {
                count++;
            }
        }
        System.out.println("Bit Count" + Integer.bitCount(n));
        return count;
    }
    
    public boolean getBit(int n, int i)
    {
        System.out.println(1<<i);
        return(n&(1<<i))!=0; //check lower bit
    }
}
