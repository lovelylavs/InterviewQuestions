/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackofstacks;

/**
 *
 * @author Lavanya
 */
public class Node {
	public Node above;
	public Node below;
	public int value;
	public Node(int value) {
		this.value = value;
	}
}
