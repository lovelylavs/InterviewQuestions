/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

/**
 *
 * @author Lavanya
 */

	
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class DeletRepeatedLexi {
	public static int getIndex(Character[] array, char c) {
		for (int i=0; i < array.length;i++)
			if (array[i] == c)
				return i;
		return -1;
	}
	public static HashMap<Character,Integer> getFrequency(String st)
	{
		HashMap<Character,Integer> counter= new HashMap<Character, Integer>();
		for (int i=0;i<st.length();i++)
		{
			char c = st.charAt(i);
			if (counter.get(c) == null)
			{
				counter.put(c, 0);
			}
			counter.put(c, counter.get(c)+1);
			
		}
		return counter;
	}
	private static boolean lowerStillExists(Character[] charArray, HashMap<Character, Integer> counter, char c) {
		int index = getIndex(charArray, c);
		for (int i=0;i<index;i++)
			if (counter.get(charArray[i]) > 0)
				return true;
		return false;
	}
	public static String lexicographical(String st)
	{
		HashMap<Character,Integer> counter = getFrequency(st) ;
		
		//get sorted array of the characters that occured. Note that it can be max 26, so O(1) for sorting.
		Set<Character> s = counter.keySet();
		Character[] charArray = s.toArray(new Character[0]);
		Arrays.sort(charArray);
		
		
		String finalString="";
		for (int i=0;i <st.length();i++)
		{
			char c = st.charAt(i);
			int numbersRemaining = counter.get(c);
			if (!lowerStillExists(charArray, counter, c) || numbersRemaining ==1)
			{
				if (numbersRemaining >0) {
					finalString=finalString+c;
					counter.put(c, -1);
				}
			}
			else
				counter.put(c,numbersRemaining-1);
		}
		return finalString;
		
		
	}
	

	public static void main(String[] args) {
		System.out.println(lexicographical("cbacdcbc"));
		System.out.println(lexicographical("acbac"));
		System.out.println(lexicographical("abcadaba"));
		System.out.println(lexicographical("acbac"));

	}

}