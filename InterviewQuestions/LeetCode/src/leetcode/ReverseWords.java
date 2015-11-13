/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 *
 * @author Lavanya
 */
public class ReverseWords {
    
    public static void main(String[] args){
        String s= " 1";
        System.out.println(reverseWords(s));
    }
    
    public static String reverseWords(String s) {
        
        //check for base condition
        if(s.length() ==0 )
           return "";
        
        //Split the string
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        //for length of string
        for(int i=arr.length-1; i>=0;--i){
            if(!arr[i].equals("")){
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() ==0?"":sb.substring(0,sb.length()-1);
    }
}
