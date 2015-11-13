/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

import java.io.IOException;

/**
 *
 * @author Lavanya
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    static void MergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            Merge(A, p, q, r);
        }
    }

    static void Merge(int[] A, int p, int q, int r) {
	int ls = q-p+1;
	int rs = r-q;
        int[] L = new int[ls];
        int[] R = new int[rs];
        for(int i=p; i<=q; i++) L[i-p] = A[i];
	for(int i=q+1; i<=r; i++) R[i-(q+1)] = A[i];
        int i = 0; int j = 0;
        for(int k=p; k<=r; k++) {
	    if ((j>=rs) || ((i<ls) && (L[i] <= R[j])))
		A[k] = L[i++];
	    else
		A[k] = R[j++];
	}
        return;
    }

    public static void main(String[] args) throws IOException{
        int n = 7;
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = n-i;
        }
        MergeSort(A, 0, n-1);

        for (int j = 0; j < A.length-1; j++) {
            if(A[j] > A[j+1]) {
		System.out.println("Sorting failed :-(");
		return;
	    }
        }
	System.out.println("Success!");
    }
    
}
