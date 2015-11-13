/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;

/**
 *
 * @author Lavanya
 */
public class PalindromePartition {
    
    public static void main(String[] args){
        String s= "abbaacaa";
        System.out.println(palindromePartitioning(s));
    }
    public static List<String> palindromePartitioning(String s) {
 
	List<String> result = new ArrayList<>();
 
	if (s == null)
		return result;
 
	if (s.length() <= 1) {
		result.add(s);
		return result;
	}
 
	int length = s.length();
 
	int[][] table = new int[length][length];
 
	// l is length, i is index of left boundary, j is index of right boundary
	for (int l = 1; l <= length; l++) {
            
            //loop from l to length-1
		for (int i = 0; i <= length - l; i++) {
			int j = i + l - 1;
			if (s.charAt(i) == s.charAt(j)) {
				if (l == 1 || l == 2) {
					table[i][j] = 1;
				} else {
					table[i][j] = table[i + 1][j - 1];
				}
				if (table[i][j] == 1) {
					result.add(s.substring(i, j + 1));
				}
			} else {
				table[i][j] = 0;
			}
		}
	}
 
	return result;
}

}
