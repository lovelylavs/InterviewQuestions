/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class StringComb {
    
    public static void main(String[] args)
    {
        List<String> output = genPattern("1?00?101");
		for (String o : output) {
			System.out.println(o);
		}
    }
    public static List<String> strComb(String pattern)
    {
        List<String> genStrings = new ArrayList<>();
        int pos = pattern.indexOf("?");
        
        if(pos < 0)
        {
            genStrings.add(pattern);
        }
        else
        {
            String zeroPattern = pattern.substring(0,pos)+"0"+pattern.substring(pos+1);
            genStrings.addAll(strComb(zeroPattern));
            
            String onePattern = pattern.substring(0,pos)+"1"+pattern.substring(pos+1);
            
            genStrings.addAll(strComb(onePattern));
        }
        return genStrings;
    }
    
    public static List<String> genPattern(String pattern)
    {
        List<String> newString = new ArrayList<>();
        
        char[] chars = pattern.toCharArray();
        
        int totalWC = 0;
		for (char c : chars) {
			if (c == '?')
			totalWC++;
		}
		
		int totalPerms = (int)Math.pow(2, totalWC), position = 0;
		List<String> output = new ArrayList<>(totalPerms);
		
		StringBuilder sb = new StringBuilder();
		for (int i =0; i < totalPerms;i++) {
			sb = new StringBuilder();
			position = totalWC-1;
			for (int j =0;j < chars.length; j++) {
				char c = chars[j];
				if (c == '?') {
					sb.append(((i & (1<<position)) != 0) ? '1' : '0' );
					position--;
				} else {
					sb.append(c);
				}
			}
			output.add(sb.toString());
		}
		return output;
    }
}
