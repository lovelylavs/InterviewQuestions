/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lavanya
 */
public class WildCard 
{
    public static boolean isMatch(String s1, String s2)
    {
        if(s1.length()==0 )
        {
            if(s2.length()==0)
                return true;
            if(s2.charAt(0)=='*')
                return isMatch(s1, s2.substring(1));
            return false;
        }
        if(s2.length()==0)
            return false;
        if(s2.charAt(0)=='?' || s2.charAt(0)==s1.charAt(0))
            return isMatch(s1.substring(1), s2.substring(1));
        if(s2.charAt(0)=='*')
        {
            int i=0;
            while(i<s2.length()&&s2.charAt(i)=='*')
                i++;
            return isMatch(s1.substring(1), s2) || isMatch(s1, s2.substring(i));
        }
        return false;
    }
    public static void main(String[] args)
    {
        System.out.println(isMatch("aaa", "a*"));
    }
}
