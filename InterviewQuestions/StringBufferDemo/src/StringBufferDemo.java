/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lavanya
 */
public class StringBufferDemo {

	public static void main(String[] args) {
		//    	Examples of Creation of Strings
		StringBuffer strBuf1 = new StringBuffer("Bobby");
		StringBuffer strBuf2 = new StringBuffer(100); //With capacity 100
		StringBuffer strBuf3 = new StringBuffer(); //Default Capacity 16
		System.out.println("strBuf1 : " + strBuf1);
		System.out.println("strBuf1 capacity : " + strBuf1.capacity());
		System.out.println("strBuf2 capacity : " + strBuf2.capacity());
		System.out.println("strBuf3 capacity : " + strBuf3.capacity());
		System.out.println("strBuf1 length : " + strBuf1.length());
		System.out.println("strBuf1 charAt 2 : " + strBuf1.charAt(2));
		//    	A StringIndexOutOfBoundsException is thrown if the index is not valid.
		strBuf1.setCharAt(1, 't');
		System.out.println("strBuf1 after setCharAt 1 to t is : "
				+ strBuf1);
		System.out
				.println("strBuf1 toString() is : " + strBuf1.toString());
		strBuf3.append("beginner-java-tutorial");
		System.out.println("strBuf3 when appended with a String : "
				+ strBuf3.toString());
		strBuf3.insert(1, 'c');
		System.out.println("strBuf3 when c is inserted at 1 : "
				+ strBuf3.toString());
		strBuf3.delete(1, 'c');
		System.out.println("strBuf3 when c is deleted at 1 : "
				+ strBuf3.toString());
		strBuf3.reverse();
		System.out.println("Reversed strBuf3 : " + strBuf3);
		strBuf2.setLength(5);
		strBuf2.append("jdbc-tutorial");
		System.out.println("strBuf2 : " + strBuf2);
		//    	We can clear a StringBuffer using the following line
		strBuf2.setLength(0);
		System.out.println("strBuf2 when cleared using setLength(0): "
				+ strBuf2);
	}
}
