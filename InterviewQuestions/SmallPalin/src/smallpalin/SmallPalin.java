/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smallpalin;

/**
 *
 * @author Lavanya
 */
public class SmallPalin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(checkPalin("abcdcba"));
        System.out.println(shortestPalindrome("aacecaaa"));
    }
    
    //Given "aacecaaa", return "aaacecaaa". add a
    //Given "abcd", return "dcbabcd". add dcb abcdcba
    
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
    
    public static boolean checkPalin(String s)
    {
        int j=0;
        for(int i=s.length()-1; i>=i/2; i--)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                j++;
                continue;
                
            }
            else
                return false;
        }
        return true;
    }
    
   
    
}
