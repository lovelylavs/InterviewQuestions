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
public class DynLongPalin {
   
    public static void main(String[] args){
        String s= "abcacbc";
        System.out.println(longestPalin(s));
    }
    public static String longestPalin(String s){
        //base case if null
        if(s==null)
            return s;
        
        if(s.length()<=1){
            return s;
        }
        
        int maxLen=0;
        String longestStr="";
        
        int len = s.length();
        
        //Storage for sub problems
        int[][] table = new int[len][len];
        
        //every single string is a palindrome
        for(int i=0; i< s.length(); i++){
            table[i][i]=1;
        }
        //two consecutive same letters can be palindrome
        for(int i=0; i<=len-2; i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    table[i][i+1]=1;
                    longestStr=s.substring(i,i+2);
                }
            }
        
        //Calculating all the sub problems
            for(int l=3; l<=len; l++){
                for(int i=0; i<=len-l;i++){
                    int j=i+l-1;
                    
                    if(s.charAt(i)==s.charAt(j)){
                        table[i][j]=table[i+1][j-1];
                        if(table[i][j]==1 && l>maxLen){
                            longestStr=s.substring(i,j+1);
                        }
                        else{
                            table[i][j]=0;
                        }
                    }
                }
            }
            
            return longestStr;
            
    }
}
