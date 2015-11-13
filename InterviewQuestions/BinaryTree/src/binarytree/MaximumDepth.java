/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author Lavanya
 */
public class MaximumDepth {
     public int maxDepth(Node root) {
        if(root == null)
          return 0;
        
        else return 1+ Math.max(maxDepth(root.Left),maxDepth(root.Right));
    }
     
     
     
}

