/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uniquearray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Lavanya
 */
public class UniqueArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Integer> initialList = Arrays.asList(1,5,8,9,9,1,5,8);
        System.out.printf("\nInitial list: %s%n", initialList);
        sortList(initialList);
    }
 
    public static void sortList (List<Integer> myList){
        Set<Integer> hashsetList = new HashSet<Integer>(myList);
        System.out.printf("\nUnique values using HashSet: %s%n", hashsetList);
 
        Set<Integer> treesetList = new TreeSet<Integer>(myList);
        System.out.printf("\nUnique values using TreeSet - Sorted order: %s%n", treesetList);
    }
    
}
