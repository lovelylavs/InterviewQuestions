/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementsubstring;

/**
 *
 * @author Lavanya
 */
public class ImplementSubString {

    /**
     * @param args the command line arguments
     */
    public static int mySubString(String str,String sub)
    {
        int strSubLen = sub.length();
        int strLen = str.length();
        int jValue=0;
        
        if(strSubLen>=1)
        {
        for(int iCtr =0; iCtr<strLen; iCtr++)
        {
            if(str.charAt(iCtr)==sub.charAt(jValue))
            {                
                jValue++; 
                if(jValue==strSubLen)
                {
                    return (iCtr - strSubLen)+1;
                }
            }
            else
            {
                jValue=0;
            }
        }
        }
        return -1;
    }
    public static void main(String[] args) 
    {   
        System.out.println(mySubString("lazanvan", "van"));
    }
        // TODO code application logic here
    }
    

