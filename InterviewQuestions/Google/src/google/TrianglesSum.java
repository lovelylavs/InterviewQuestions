/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lavanya
 */
public class TrianglesSum {
    
    public static void main(String[] args){
    ArrayList<ArrayList<Integer>> triangle = new  ArrayList<>();
    ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(2));
    ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(3,4));
    ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(6,5,7));
    ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(4,1,8,3));
     triangle.add(a1);
     triangle.add(a2);
     triangle.add(a3);
     triangle.add(a4);
        System.out.println(trianglesSum(triangle));
    }
    
   
    
    
    public static int trianglesSum(ArrayList<ArrayList<Integer>> triangle)
    {
        int[] total = new int[triangle.size()];
	int l = triangle.size() - 1;
 
	for (int i = 0; i < triangle.get(l).size(); i++) {
		total[i] = triangle.get(l).get(i);
	}
 
	// iterate from last second row
	for (int i = triangle.size() - 2; i >= 0; i--) {
		for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
			total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
		}
	}
        Math.random();
	return total[0];
    }
}
