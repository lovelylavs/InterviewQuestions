/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dfsbfs;

/**
 *
 * @author Lavanya
 */
import java.util.ArrayList;

public class Tree<T> {

	private Node<T> root;

	public Tree(Node<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null);
	}

        //gets the root of the tree
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean exists(T key) {
		return find(root, key);
	}

	public int getNumberOfNodes() {
		return getNumberOfDescendants(root) + 1;
	}

	public int getNumberOfDescendants(Node<T> node) {
		int n = node.getChildren().size();
		for (Node<T> child : node.getChildren())
			n += getNumberOfDescendants(child);

		return n;

	}

	private boolean find(Node<T> node, T keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode))
			return true;

		else {
			for (Node<T> child : node.getChildren())
				if (find(child, keyNode))
					res = true;
		}

		return res;
	}
	
    private Node<T> findNode(Node<T> node, T keyNode)
    {
    	if(node == null)
    		return null;
    	if(node.getData().equals(keyNode))
    		return node;
    	else
    	{
    		Node<T> cnode = null;
    		for (Node<T> child : node.getChildren())
    			if ((cnode = findNode(child, keyNode)) != null)
    				return cnode;
    	}
    	return null;         
    } 

	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder);
		return preOrder;
	}

	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;
	}

	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node);
		for (Node<T> child : node.getChildren()) {
			buildPreOrder(child, preOrder);
		}
	}

	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child : node.getChildren()) {
			buildPostOrder(child, postOrder);
		}
		postOrder.add(node);
	}

	public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
		ArrayList<Node<T>> longestPath = null;
		int max = 0;
		for (ArrayList<Node<T>> path : getPathsFromRootToAnyLeaf()) {
			if (path.size() > max) {
				max = path.size();
				longestPath = path;
			}
		}
		return longestPath;
	}

	public int getMaxDepth()
	{
		return getLongestPathFromRootToAnyLeaf().size();
	}
	
	public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
		ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
		ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
		getPath(root, currentPath, paths);

		return paths;
	}

	private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
			ArrayList<ArrayList<Node<T>>> paths) {
		if (currentPath == null)
			return;
                //Add the node to current path
		currentPath.add(node);
                 
                //If the node does not have any children add this path to output path
		if (node.getChildren().isEmpty()) {
			// This is a leaf
			paths.add(clone(currentPath));
		}
                
                //For each node find if it has children and
                //then find the path assocated with the child
		for (Node<T> child : node.getChildren())
			getPath(child, currentPath, paths);

		int index = currentPath.indexOf(node);
		for (int i = index; i < currentPath.size(); i++)
			currentPath.remove(index);
	}

	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<>();
		for (Node<T> node : list)
			newList.add(new Node<>(node));

		return newList;
	}
}

