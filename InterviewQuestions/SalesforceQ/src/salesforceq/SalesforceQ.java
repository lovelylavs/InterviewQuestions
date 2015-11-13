/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salesforceq;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lavanya
 */
public class SalesforceQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Integer> small = new ArrayList<Integer>();
        small.add(4);
        small.add(5);
        small.add(7);
        small.add(8);
        small.add(9);
        small.add(2);
        small.add(5);
        small.add(9);
        Collections.shuffle(small);
        
        System.out.println(small.get(0));
        shuf();
    }
    public static void shuf()
    {
        Random randIndex = new Random();
         int[] card = new int[52];
         for(int i=0;i<52;i++)
         {
             card[i]=i;
         }
         for(int i = 1; i < 52; i++) 
         {
            int j = randIndex.nextInt(i);
            int tmp = card[i];
            card[i] = card[j];
            card[j] = tmp;
        }
         
         for(int i=0;i<52;i++)
             System.out.println(card[i]);
    }
}
