/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class SplitString {
    
    public static void main(String[] args)
    {
        System.out.println(splitString("ilovegooglecodelife"));
    }
    public static boolean splitString(String s)
    {
        int len = s.length();
        
        //base case
        if(len ==0 )
            return true;
        
        //Run a for loop such that we try all words of size 1 to entire size
        for(int i=1; i<=len; i++)
        {
            //We check if current prefix is in dictionary
            //then recursively check for remaining string
            if(dictionaryContains(s.substring(0,i)) && splitString(s.substring(i,len)))
                return true;
        }
        
        //if we tried all and still no success
        return false;
    }
    
    //Dictionary that holds the list of words
    public static boolean dictionaryContains(String word)
    {
        List<String> dictionary= new ArrayList
                <>(Arrays.asList("love","google","android","using","life","at","code","i"));
        
        return dictionary.contains(word);
    }
}
