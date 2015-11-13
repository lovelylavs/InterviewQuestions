/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stattest;

/**
 *
 * @author Lavanya
 */

class StatFirst
{
    public static void meth()
    {
        System.out.println("I am in first class");
    }
}
public class StatTest extends StatFirst{

    /**
     * @param args the command line arguments
     */
    public static void meth()
    {
        System.out.println("I am in second class");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        StatFirst stat = new StatTest();
        stat.meth();
        
    }
    
}
