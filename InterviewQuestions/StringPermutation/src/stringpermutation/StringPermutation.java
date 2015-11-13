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
public class StringPermutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringPermutation sPermut = new StringPermutation();
        System.out.println(sPermut.isPermuted("lavanya", "aynaval"));
    }
    
    /* Through the string is permuted the contents of both string is same*/
    public boolean isPermuted(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        return sort(s1).equals(sort(s2));
        
    }
    
    //Using Java Utils sort function
    public String sort(String s)
    {
        char[] strValue = s.toCharArray();
        java.util.Arrays.sort(strValue);
        
        //make string from char array
        return new String(strValue);
    }
}
