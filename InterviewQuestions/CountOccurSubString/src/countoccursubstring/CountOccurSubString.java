/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countoccursubstring;

/**
 *
 * @author Lavanya
 */
public class CountOccurSubString {

    /**
     * @param args the command line arguments
     */
    public static int subStrOcc(String str,String sub)
    {
        int strSubLen = sub.length();
        int strLen = str.length();
        int jValue=0;
        int subCount=0;
        if(strSubLen>=1)
        {
        for(int iCtr =0; iCtr<strLen; iCtr++)
        {
            if(str.charAt(iCtr)==sub.charAt(jValue))
            {                
                jValue++; 
                if(jValue==strSubLen)
                {
                    subCount++;
                    jValue=0;
                }
            }
            else
            {
                jValue=0;
            }
        }
        }
        return subCount;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(subStrOcc("lavavav", "av"));
    }
    
}
