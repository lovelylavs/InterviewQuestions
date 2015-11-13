/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strstr;

/**
 *
 * @author Lavanya
 */
public class StrStr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(strStr("water", "ate"));
    }
    
     public static int strStr(String haystack, String needle) {
  
      int hLength=haystack.length(); 
      int nLength=needle.length(); 
      if(hLength<nLength) return -1; 
      if(nLength==0) return -1;
      for(int i=0; i<=hLength-nLength; i++)
      {
        if(haystack.charAt(i)==needle.charAt(0))
        {
          int j=0; 
          for(; j<nLength; j++)
          {
            if(haystack.charAt(i+j)!=needle.charAt(j))
            {
              break; 
            }
          }
          if(j==nLength)  return i;
        }  
      }
      return -1; 
    }  
}
