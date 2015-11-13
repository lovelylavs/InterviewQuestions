/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;
import java.util.*;
/**
 *
 * @author Lavanya
 */
public class Anagram {
   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

         String one ="geeksforgeeks";
         String two = "forgeeksgeeks";
        
        
            System.out.println(areAnagrams(one,two));
        
    }
    
    public static boolean areAnagrams(String strFirst, String strSecond )
    {
        if(strFirst.length() < strSecond.length())
            return false;
        //Assume ASCII charset of size 256 alphabets
        int[] charCount = new int[256];

        getCharCount(strFirst,charCount);

        for( int i = 0; i < strSecond.length(); i++ )
        {
            char ch = strSecond.charAt(i);
            // If count of ch is more in second string, return false
            if( charCount[ch] <= 0 )
                return false;
            else
                charCount[ch]--;
        }

        for( int i = 0; i < 256; i++ )
        {
            if( charCount[i] > 0 )
                return false;
        }
        return true;
    }
    public static void getCharCount(String strInput, int[] charCount)
    {
        for( int i = 0; i < strInput.length(); i++ )
        {
            charCount[ strInput.charAt(i)]++;
        }
    }
}
