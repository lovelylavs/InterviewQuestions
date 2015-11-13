/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lavanya
 */
public class PhoneTest {
    
    public static void main(String[] args)
    {
        solution("00:01:07,400-234-090\n" +
"   00:05:01,701-080-080\n" +
"   00:05:00,400-234-090");
        
        System.out.println(lengthOfLongestSubstring("a0bb"));
    }
    public static void solution(String S) {
        // write your code in Java SE 8
       
        final Pattern pattern = Pattern.compile("(?m)^(\\d\\d:\\d\\d:\\d\\d)");
    final Matcher matcher= pattern.matcher(S);
    while(matcher.find())
    {
        System.out.printf("[%s]\n", matcher.group(1));
    }  
    
    String str[] = S.split(",|\n");
    for(int i=0; i< str.length; i++)
    {
        System.out.println(str[i]);
    }
      String s = "00:01:07";
      int seconds=0;
    String[] hhmmss = s.split(":");
        seconds += Integer.valueOf(hhmmss[0]) * 60 * 60;
        seconds += Integer.valueOf(hhmmss[1]) * 60;
        seconds += Integer.valueOf(hhmmss[2]);
        
        int res=0;
        if(seconds < 300)
        {
            res+=seconds*300;
        }
        else
        {
            res += seconds / 60 * 150;
            
        }
        
    }
    
    
    public static int lengthOfLongestSubstring(String s) {
        
       

String[] res = s.replaceAll("(?<=\\p{L})(?=\\d)", ":").split("(?<=\\d)(?=\\p{L})");
    int length=-1;
    String str="";
    if(!s.matches(".*\\d.*"))
    {
        return -1;
    }
    for (String t : res) {
        
        boolean hasUppercase = !t.equals(t.toLowerCase());
       
        if(hasUppercase)
        {
            if(t.length()>length)
            {
                str=t;
                length=str.length();
            }
        }
        System.out.println(t);
    
    }
    
    return length;
    }
}
