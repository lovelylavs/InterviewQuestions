
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringpermutation;

/**
 *
 * @author Lavanya
 */
public class StringPermEfficient {
    
     public static void main(String[] args) {
        // TODO code application logic here
        StringPermEfficient sPermut = new StringPermEfficient();
        System.out.println(sPermut.permutation("aavanya", "aynaval"));
    }
     
    public boolean permutation(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        
        int[] letters = new int[256];
        
        char[] s1_array = s1.toCharArray();
        for(char c: s1_array)
            letters[c]++;
        
        for(int i=0; i<s2.length(); i++)
        {
            int c= (int) s2.charAt(i);
            if(--letters[c]<0)
            {
                return false;
            }
        }
        return true;
   }
    
    
    
}
