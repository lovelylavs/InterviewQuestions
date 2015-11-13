/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryhex;

/**
 *
 * @author Lavanya
 */
public class BinaryHex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryHex binHexEq = new BinaryHex();
        System.out.println("The values are" + binHexEq.binaryHexEqual("1111", "FF"));
    }
    
    public boolean binaryHexEqual(String binary, String hex)
    {
        double binValue = convertToBase(binary, 2);
        double hexValue = convertToBase1(hex, 16);
        if(binValue<0 || hexValue <0 ) return false;
        else
            return binValue==hexValue;
    }
    
    public int digitToValue(char ch)
    {
        if(ch>='0' && ch<='9') return ch-'0';
        else if(ch>='A' && ch<='F') return 10 + ch -'A';
        else if (ch >='a' && ch<='f') return 10 + ch -'a';
        return -1;
    }
    public double convertToBase(String number, int base)
    {
        if(base<2||(base>10 && base!= 16)) return -1;
        double dblValue=0;
        for(int jCtr=0, iCtr=(number.length()-1);jCtr<number.length();jCtr++,iCtr--)
        {
            dblValue = dblValue+digitToValue(number.charAt(jCtr))*Math.pow(base, iCtr);
        }
        return dblValue;
    }
    
    public int convertToBase1(String number, int base)
    {
         if(base<2||(base>10 && base!= 16)) return -1;
        int intValue=0;
        for(int i=number.length()-1;i>=0;i--)
            
        {   //check if the digit is in correct range
            int digit = digitToValue(number.charAt(i));
            if(digit<0 || digit >=base){
                return -1;
            }
            int exp = number.length()-1-i;
            intValue +=digit * Math.pow(base, exp);
        }
        return intValue;
    }
    
}
