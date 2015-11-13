/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringmanipulations;

/**
 *
 * @author Lavanya
 */
public class MaxRepeatesString {
    
    public static void main(String[] args) {
		System.out.println(maxRepeated("aaabbbbbbbbccccc"));
    }
    
    public static String maxRepeated(String str)
    {
        char[] array = str.toCharArray();
        int maxCount =1;
        
        char maxChar = array[0];
        for(int i=0,j=0; i <str.length()-1;i=j )
        {
            int count =1;
            while(++j <str.length() &&array[i]==array[j])
                count++;
            if(count > maxCount )
            {
                maxCount=count;
                maxChar=array[i];
            }
        }
        return (maxChar +"="+maxCount);
    }
    
}
