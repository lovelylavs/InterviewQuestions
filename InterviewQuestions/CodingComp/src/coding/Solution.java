/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coding;

/**
 *
 * @author Lavanya
 */


public class Solution {
public TreeNode buildTree(int[] inorder, int[] postorder) {
if (inorder==null||inorder.length==0||postorder==null ||postorder.length==0){
return null;
}
int iSt=0;
int iEd=inorder.length-1;
int pSt=0;
int pEd=postorder.length-1;
return buildTree(inorder, iSt, iEd, postorder, pSt, pEd);
}
private TreeNode buildTree(int[] inorder, int iSt, int iEd, int[] postorder, int pSt, int pEd){
if (iSt>iEd || pSt>pEd){
return null;
}
TreeNode root=new TreeNode (postorder[pEd]);
int index=0;
for (int i=iSt; i<=iEd; i++){
if (inorder[i]==root.val){
index=i;
break;
}
}
int len=index-iSt;
root.left=buildTree(inorder, iSt, index-1, postorder, pSt, pSt+len-1);
root.right=buildTree(inorder, index+1, iEd, postorder, pSt+len-1+1, pEd-1);
return root;
}
}
