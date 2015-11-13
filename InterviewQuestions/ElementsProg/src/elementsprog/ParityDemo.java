/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elementsprog;

/**
 *
 * @author Lavanya
 */
public class ParityDemo {
    
    public static void main(String[] args)
    {
        System.out.println(getParity(1011L));
        int a = 60;
        int b =13;
        int c=0;
    }
    public static short getParity(Long num)
    {
        short result=0;
        while(num != 0)
        {
            result ^=1;
            num >>=1;
        }
        return result;
    }
}
