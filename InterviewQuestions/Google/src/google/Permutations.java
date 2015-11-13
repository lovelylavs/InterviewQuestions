/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.*;
/**
 *
 * @author Lavanya
 */
public class Permutations {
    
    public static void main(String[] args){
        int[] nums = {2,3,4,5};
        Permutations permuteClass = new Permutations();
        
        permuteClass.subsets(nums);
        ArrayList<ArrayList<Integer>> result = permuteClass.permute(nums);
        for(ArrayList<Integer> r1 : result){
            System.out.print("{");
            for(int n: r1){
                System.out.print(n);
            }
            System.out.print("}");
            System.out.println("");
        }
        
        }
        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            permute(num, 0, result);
            return result;
    }

    void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {

            if (start >= num.length) {
                    ArrayList<Integer> item = convertArrayToList(num);
                    result.add(item);
            }

            for (int j = start; j <= num.length - 1; j++) {
                    swap(num, start, j);
                    permute(num, start + 1, result);
                    swap(num, start, j);
            }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int h = 0; h < num.length; h++) {
                    item.add(num[h]);
            }
            return item;
    }

    private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	if (S == null)
		return null;
 
	Arrays.sort(S);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
 
	for (int i = 0; i < S.length; i++) {
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
 
		//get sets that are already in result
		for (ArrayList<Integer> a : result) {
			temp.add(new ArrayList<>(a));
		}
 
		//add S[i] to existing sets
		for (ArrayList<Integer> a : temp) {
			a.add(S[i]);
		}
 
		//add S[i] only as a set
		ArrayList<Integer> single = new ArrayList<>();
		single.add(S[i]);
		temp.add(single);
 
		result.addAll(temp);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
}


}
