/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArraysStrings;

import java.math.BigInteger;

/**
 *
 * @author Lavanya
 */
public class UniqChar 
{
    public static boolean isUniqueChars(String str) {
    if (str.length() > 256) { // NOTE: Are you sure this isn't 26?
        return false;
    }
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i) - 'a';
        if ((checker & (1 << val)) > 0) return false;
        checker |= (1 << val);
    }
    return true;
    }
    
    
    public static void main(String[] args) {
    	UniqChar test = new UniqChar();
        test.isUniqueChars("addde");
    }
}
