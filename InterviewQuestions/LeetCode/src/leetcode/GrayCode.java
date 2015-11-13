/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lavanya
 */
public class GrayCode {
    
     public static void main(String[] args) {
         List<Integer> n = grayCode(3);
         for(int i=0; i< n.size();i++)
             System.out.println(n.get(i));
     }
     
    public static List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
    }
}
