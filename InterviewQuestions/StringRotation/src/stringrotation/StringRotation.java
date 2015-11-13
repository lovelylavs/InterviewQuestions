/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringrotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class StringRotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1=null,s2=null;
        System.out.println("Enter strings");
        Scanner sc = new Scanner(System.in);
        //s1=sc.next();
        //s2=sc.next();
        //System.out.println(isRotation(s1, s2));

            
         String s = sc.nextLine();

         String[] words = s.split(" ");

         
         int rotation = 2;
         for (int i = 0;i < words.length;i++)
         {
           System.out.print(words[(i + words.length - rotation)%words.length] + " ");
         }
      
        int x = 10001000;
        int y = 10011001;
        System.out.println(checkConsecutive2(x,y));
    
    }
    
   static boolean  isRotation(String s1,String s2) {
    return (s1.length() == s2.length()) && (s1+s1).contains(s2);
}
   
   public static int checkConsecutive2(int b1, int b2){
    int x =  (b1 ^ b2);

    if((x & (x - 1)) !=0){
      return 0;
    }else{
      return 1;
    }

}
   
   public int findNextBiggestNumber(int input  )   {
    //take 1358642 as input for example.
    //Step 1: split the whole number to a list for individual digital   1358642->[2,4,6,8,5,3,1]
    // this step is O(n)
    int digitalLevel=input;

    List<Integer> orgNumbersList=new ArrayList<Integer>()   ;

    do {
        Integer nInt = new Integer(digitalLevel % 10);
        orgNumbersList.add(nInt);

        digitalLevel=(int) (digitalLevel/10  )  ;


    } while( digitalLevel >0)    ;
    int len= orgNumbersList.size();
    int [] orgNumbers=new int[len]  ;
    for(int i=0;i<len;i++){
        orgNumbers[i ]  =  orgNumbersList.get(i).intValue();
    }
    //step 2 find the first digital less than the digital right to it
    // this step is O(n)


    int firstLessPointer=1;
    while(firstLessPointer<len&&(orgNumbers[firstLessPointer]>orgNumbers[ firstLessPointer-1 ])){
        firstLessPointer++;
    }
     if(firstLessPointer==len-1&&orgNumbers[len-1]>=orgNumbers[len-2]){
         //all number is in sorted order like 4321, no answer for it, return original
         return input;
     }

    //when step 2 step finished, firstLessPointer  pointing to number 5

     //step 3 fristLessPointer found, need to find  to  first number less than it  from low digital in the number
    //This step is O(n)
    int justBiggerPointer=  0 ;

    while(justBiggerPointer<firstLessPointer&& orgNumbers[justBiggerPointer]<orgNumbers[firstLessPointer]){
        justBiggerPointer++;
    }
    //when step 3 finished, justBiggerPointer  pointing to 6

    //step 4 swap the elements  of justBiggerPointer and firstLessPointer .
    // This  is O(1) operation   for swap

   int tmp=  orgNumbers[firstLessPointer] ;

    orgNumbers[firstLessPointer]=  orgNumbers[justBiggerPointer]  ;
     orgNumbers[justBiggerPointer]=tmp ;


     // when step 4 finished, the list looks like        [2,4,5,8,6,3,1]    the digital in the list before
     // firstLessPointer is already sorted in our previous operation
     // we can return result from this list  but  in a differrent way
    int result=0;
    int i=0;
    int lowPointer=firstLessPointer;
    //the following pick number from list from  the position just before firstLessPointer, here is 8 -> 5 -> 4 -> 2
    //This Operation is O(n)
    while(lowPointer>0)        {
        result+= orgNumbers[--lowPointer]* Math.pow(10,i);
        i++;
    }
    //the following pick number from list   from position firstLessPointer
    //This Operation is O(n)
    while(firstLessPointer<len)        {
        result+= orgNumbers[firstLessPointer++ ]* Math.pow(10,i);
        i++;
    }
     return  result;

}
}

