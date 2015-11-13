/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lavanya
 */
public class DiffSets {
    
    public static void main(String[] args)
    {
        List<Integer> set1 = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 9, -4));
        List<Integer> set2 = new ArrayList<>(Arrays.asList(-1, 0, 5, 2, 7, -4));

                for (Integer key: set1) {
            if (set2.contains(key))
                set2.remove(key);
            else
                set2.add(key);
        }
                
          for(Integer a : set2)
            System.out.println(a);
          
     /*   Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);

        Set<Integer> difference = new HashSet<>();
        difference.addAll(set1);
        difference.addAll(set2);
        difference.removeAll(intersection);
        
        for(Integer a : difference)
            System.out.println(a);*/
    }
}
