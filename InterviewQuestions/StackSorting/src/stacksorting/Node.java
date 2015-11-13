/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stacksorting;

/**
 *
 * @author Lavanya
 */
public class Node {
   Node next;
  
   int data;
   
   public Node(int val)
   {
       next = new Node(val);
   }
   
   public int getData()
   {
           return data;
   }
   
}
