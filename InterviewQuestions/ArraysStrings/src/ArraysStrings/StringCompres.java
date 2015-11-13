package ArraysStrings;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.RowFilter.Entry;

public class StringCompres 
{
	String Str_Comp(String strInput)
	{
		String strOutput = "";
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i< strInput.length(); i++)
		{
			Character chNow = strInput.charAt(i);
			if(map.containsKey(chNow))
			{
				map.put(chNow,map.get(chNow)+1);
			}
			else
			{
				map.put(chNow, 1);
			}
		}
		for(java.util.Map.Entry<Character, Integer> entry : map.entrySet())
		{
			strOutput+=entry.getValue()+""+entry.getKey().charValue();
			
		}
		return strOutput;
	}
	
	public static void main(String args[])
	{
		StringCompres strComp = new StringCompres();
		String myStr = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			myStr = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String newString = strComp.Str_Comp(myStr);
	    System.out.println(newString);
	}
}
