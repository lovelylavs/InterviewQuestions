/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testpalindrome;

/**
 *
 * @author Lavanya
 */
public class TestPalindrome 
{
    public String longestPalindrome(String s) {
	if (s.isEmpty()) {
		return null;
	}
 
	if (s.length() == 1) {
		return s;
	}
 
	String longest = s.substring(0, 1);
	for (int i = 0; i < s.length(); i++) {
		// get longest palindrome with center of i
		String tmp = helper(s, i, i);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
 
		// get longest palindrome with center of i, i+1
		tmp = helper(s, i, i + 1);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
	}
 
	return longest;
}
 
// Given a center, either one letter or two letter, 
// Find longest palindrome
public String helper(String s, int begin, int end) {
	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
		begin--;
		end++;
	}
	return s.substring(begin + 1, end);
}

    public static boolean isPalindrome(int x)
    {
        int num=x;
        int rev=0;
        while(num>0)
        {
            int rem = num%10;
            rev = rev*10+rem;
            num=num/10;
        }
        if(x==rev)
            return true;
        else 
            return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestPalindrome palin = new TestPalindrome();
        System.out.println("Is palindrome"+isPalindrome(1521));
        System.out.println("Longest palindrome "+ palin.longestPalindrome("madam111222111"));
    }
    
}
