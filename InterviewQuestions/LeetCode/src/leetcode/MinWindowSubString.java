/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Lavanya
 */
public class MinWindowSubString {
    
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWString(s, t));
    }
    
    public static String minWString(String s, String t){
        
        //If the length of second string is greater return empty
       if(t.length() > s.length()){
           return "";
       }
       String minWind="";
       //character count for t
        HashMap<Character,Integer> t1 = new HashMap<>();
        for(int i=0; i< t.length();i++){
            char c = t.charAt(i);
            if(t1.containsKey(c)){
                t1.put(c,t1.get(c)+1);
            }
            else
                t1.put(c,1);
        }
        
        HashMap<Character,Integer> s1 = new HashMap<>();
        int val=0;
        int len=s.length()+1;
        int result=0;
        
        String minStr="";

        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            
            //If the t contains character from s
            if(t1.containsKey(c)){
                
                //If s1 contains the character already 
                //if s1(c) <t1(c) increase result by 1 and put in map
                if(s1.containsKey(c)){
                    if(s1.get(c)<t1.get(c)){
                        result++;
                    }
                    s1.put(c,s1.get(c)+1);
                }
                //if we do not have c in s1 already we add
                else{
                    s1.put(c,1);
                    result++;
                }
            }
            
            //IF the result is equal to the length of t
            if(result == t.length()){
                
                //get the character(sc) in s at val
                char sc = s.charAt(val);
                
                //if s1 does not contain sc and s1(sc) >t1(sc)
                //If s1(c) occurs more times than in t1
                //it happens that there might be  amin window
                while (!s1.containsKey(sc) || s1.get(sc) > t1.get(sc)) {
                    
                    //
                if (s1.containsKey(sc) && s1.get(sc) > t1.get(sc))
                    s1.put(sc, s1.get(sc) - 1);
                    val++;//we increase val for more occurences in string
                sc = s.charAt(val);
                }

                if (i - val + 1 < len) {
                    minWind = s.substring(val, i + 1);
                    len = i - val + 1;
                }
                
            }
        }
        
        return minWind;
    }
}
