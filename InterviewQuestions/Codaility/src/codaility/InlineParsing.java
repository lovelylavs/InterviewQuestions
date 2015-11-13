/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

/**
 *
 * @author Lavanya
 */
public class InlineParsing {
    public static void main(String []args){
        String input = "5-2+20+5+11-10";
        input = input.replace(" ","");

        String parsedInteger = "";
        String operator = "";
        int aggregate = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i); 
            if (Character.isDigit(c)) {
                parsedInteger += c;
            }
            if (!Character.isDigit(c) || i == input.length()-1){
                int parsed = Integer.parseInt(parsedInteger);
                if (operator == "") {
                    aggregate = parsed;
                }
                else {
                    if (operator.equals("+")) {
                        aggregate += parsed;
                    }else if (operator.equals("-")){
                        aggregate -= parsed;
                    }
                }

                parsedInteger ="";
                operator = ""+c;
            }
        }
        System.out.println("Sum of " + input+":\r\n" + aggregate);
    }
}
