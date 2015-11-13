/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 *
 * @author Lavanya
 */
public class ShortestPalin {
    
    public static void main(String[] args){
        String s= "abcd";
        System.out.println(shortestPalindrome(s));
    }
        public static String shortestPalindrome(String s) {
        int j=0;
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                j++;                  
            }
        }
        
        if(j == s.length())
            return s;
        
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0,j)) + suffix;        
    }

}
