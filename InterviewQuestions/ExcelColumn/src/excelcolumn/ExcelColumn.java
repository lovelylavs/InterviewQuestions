/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excelcolumn;

/**
 *
 * @author Lavanya
 */
public class ExcelColumn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ExcelColumn ecol = new ExcelColumn();
        System.out.println(ecol.convertToTitle(26));
    }
    
    public String convertToTitle1(int n) {
        
        char c[] = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        String myString = "";
        while(n>0)
        {
            int rem = n%26;
            myString=c[rem]+myString;
            n/=26;
        }
        return myString;
    }
    
    public String convertToTitle(int n)
    {
        if(n<=0)
            throw new IllegalArgumentException("Input is not valid");
        
        StringBuilder sb = new StringBuilder();
        
      
        
        while(n>0)
        {
            n--;
            char ch = (char)(n %26 + 'A');
            n/=26;
            sb.append(ch);
            
        }
        
        sb.reverse();
        return sb.toString();
    }
    
}
