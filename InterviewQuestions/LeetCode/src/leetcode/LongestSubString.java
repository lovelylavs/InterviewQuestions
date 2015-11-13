/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;

/**
 *
 * @author Lavanya
 */
public class LongestSubString {
    
     public static void main(String[] args){
        String s= "abcabcbb";
        System.out.println(subString(s));
    }
     
     public static String subString(String input){

        HashSet<Character> set = new HashSet<>();

        String longestOverAll = "";
        String longestTillNow = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (set.contains(c)) {
                longestTillNow = "";
                set.clear();
            }
            longestTillNow += c;
            set.add(c);
            if (longestTillNow.length() > longestOverAll.length()) {
                longestOverAll = longestTillNow;
            }
        }

        return longestOverAll;
    }
     
    public static int lengthOfLongestSubstring(String s) {
        boolean[] set = new boolean[256];
        StringBuilder sb = new StringBuilder();
        
        int result=0;
        int start=0;
        char[] arr = s.toCharArray();

        for(int i=0; i<s.length();i++){
            char cur = arr[i];
            if(set[cur]){
                result=Math.max(result,i-start);
                
                for(int p=start; p<i; p++){
                    if(arr[p]==cur){
                        start=p+1;
                        break;
                    }
                    
                    set[arr[p]]=false;
                }
            }
            else{
                set[cur]=true;
            }
        }
        result=Math.max(arr.length-start,result);
        return result;

    }
}
