
import java.util.ArrayList;

 class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
       ArrayList<String> result=new ArrayList<String>();
       
       if (digits==null){
           return result;
       }
       
       String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       
       StringBuilder current=new StringBuilder();
       
       int index=0;
       
       buildResult(digits, index, current, keyboard, result);
       
       return result;
      
    }
    private void buildResult(String digits, int index, StringBuilder current, String[] keyboard, ArrayList<String> result){
        if (index==digits.length()){
            result.add(current.toString());
            return;
        }
        
        int num=digits.charAt(index)-'0';
        
        for (int i=0; i<keyboard[num].length(); i++){
            
            current.append(keyboard[num].charAt(i));
            buildResult(digits, index+1, current, keyboard, result);
            current.deleteCharAt(current.length()-1);
        }
        
        
    }
    
}

public class Solution {
    private char[][] map={
                     {},{},{'a','b','c'},
                     {'d','e','f'},{'g','h','i'},{'j','k','l'},
                     {'m','n','o'}, {'p','q','s','r'}, {'t','u','v'},
                     {'w','x','y','z'}     
                    };
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
                    
       ArrayList<String> result=new ArrayList<String>();
       
       StringBuffer sb=new StringBuffer();
       
       combine(digits,0,sb,result);
       
       return result;
    }
    
    private void combine(String digits, int i, StringBuffer sb, ArrayList<String> result){
        
        if (i==digits.length()){
            result.add(sb.toString());
        }
        else{
            int index=digits.charAt(i)-'0';
            int len=map[index].length;
            
            for (int j=0; j<len; j++){
                sb.append(map[index][j]);
                combine(digits, i+1, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
            
        }
    }
}