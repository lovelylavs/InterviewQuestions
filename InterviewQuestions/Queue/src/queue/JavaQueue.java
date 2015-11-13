/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queue;

/**
 *
 * @author Lavanya
 */
public class JavaQueue 
{

    private static final int intCapacity=3;
    int intArr[] = new int[intCapacity]; //array 
    int intSize=0;
    int intTop=-1;//top of the queue
    int intRear=0;//rear o fthe queue
    
    void push(int data)
    {
        if(intTop<intCapacity-1) //push elements if top less than capacity
        {
            intTop++;//increment top after inserting element
            intArr[intTop]=data;
            System.out.println("Element"+data+"is pushed into the queue!");
        }
    }
    void pop()
    {
        if(intTop>intRear){
            intRear++;//increment rear so that pop operations is done
            System.out.println("Pop operation done");
            displayQueue();           
        }
        else
            System.out.println("Underflow");
    }
    
    
    void displayQueue()
    {
        if(intTop>=intRear){
            System.out.println("Elements in queue");
            for(int i=intRear;i<=intTop;i++){
                System.out.println(intArr[i]);
            }
        }
            
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaQueue queueDemo = new JavaQueue();
        queueDemo.push(6);
        queueDemo.push(9);
        queueDemo.push(2);
        queueDemo.push(7);
        queueDemo.displayQueue();
        queueDemo.pop();
        queueDemo.displayQueue();
    }
    
}
