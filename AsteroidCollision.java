//We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid, the absolute value represents its size, and the sign
//represents its direction (positive meaning right, negative meaning left).
//Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet,
//the smaller one will explode. If both are the same size, both will explode.
//Two asteroids moving in the same direction will never meet.
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
//
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

public class AsteroidCollision {
    public static void main(String[] args) {
        CustomStack customStack=new CustomStack();
        int[] arr= {5,10,-5};
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) {
                customStack.push(arr[i]);
            }
            else{
                while(!customStack.isEmpty() && customStack.peek()>0 && customStack.peek()<-arr[i]){
                    customStack.pop();
                }
                if(!customStack.isEmpty() && customStack.peek()==-arr[i]){
                    customStack.pop();
                }
                else if(customStack.isEmpty() || customStack.peek()<0){
                    customStack.push(arr[i]);
                }
            }
        }
        for(int i=0;i<=customStack.size+1;i++){
            System.out.print(customStack.pop()+" ");
        }
    }
}

class CustomStack{
    int capacity=10;
    int[] stack;
    int size=-1;

    CustomStack(){
        stack=new int[capacity];
    }

    public boolean isEmpty(){
        return size==-1;
    }
    public boolean isFull(){
        return size==stack.length-1;
    }
    public void increaseCapacity(){
        capacity*=2;
        int[] temp =new int[capacity];
        for(int i=0;i<size;i++){
            temp[i]=stack[i];
        }
        stack=temp;
    }
    public void push(int element){
        if(isFull()){
            increaseCapacity();
        }
        size++;
        stack[size]=element;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[size--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[size];
    }
}