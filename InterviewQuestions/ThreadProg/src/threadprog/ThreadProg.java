/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadprog;

/**
 *
 * @author Lavanya
 */
public class ThreadProg implements Runnable
{

    public void run()
    {
        System.out.println("Hello from thread");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        (new Thread(new ThreadProg())).start();
    }
    
}
