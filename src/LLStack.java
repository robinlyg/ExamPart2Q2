
import java.util.EmptyStackException;

public class LLStack<E> extends ListNode implements DStack<E> {
    //
    private ListNode topOfStack;
    private int size;
    
    /**
     *push an object to the top of the stack
     * @param d  the value to be added
     */
    @Override
    public void push(double d) {
        //set topOfStack (head) to a new list node using the value and topOfStack as arguments
        //this will set the node val to d and point it to current topOfStack
        topOfStack = new ListNode(d, topOfStack);
        size++;
    }

    /** Pop - returns and removes the value on top of stack
     * @return the value at the top of the stack
     * @throws EmptyStackException if stack is empty
     */
    @Override
    public double pop() {
        //declare new double to store what will be returned, the top of stack
        double rValue;
       //if the stack is empty throw and EmptyStackException error
        if (isEmpty()) throw new EmptyStackException();
        //else set rValue to the value at topOfStack and move topOfStack to the next node
        else {
            rValue = topOfStack.val;
            topOfStack = topOfStack.next;
        }
        //reduce the size by one and return the rValue
        size--;
        return rValue;
    }


    /** Peek - returns (but does not remove) the value on top of stack
     * @return value at the top of stack
     * @throws EmptyStackException if stack is empty
     */
    @Override
    public double peek() {
        //if stack is empty throw exception
        if (isEmpty()) throw new EmptyStackException();

        //else return the value at the top of the stack
        //we do not reduce the size as this action does not remove the node
        return topOfStack.val;
    }

    /**
     * getSize - returns the size of the stack
     * @return member variable size
     */
    public int getSize() {
        return size;
    }


    /**
     * isEmpty - checks value at topOfStack
     * @return true if topOfStack is null
     */
    @Override
    public boolean isEmpty() {
        return topOfStack == null;
    }
    

    //determine which value in the stack is the smallest and move that
    // value to the top while maintaining the order of the other elements

    /**
     * smallestToTop - takes the smallest value in the stack and moves it to the top of the stack
     * we assume the stack will never become full, there are no duplicates in the stack and if the stack is
     * empty we do nothing
     */
    public void smallestToTop() {
        //if stack is empty return to calling program
        if (isEmpty()) return;

        //create temporary stack to move values to
        LLStack tempStack = new LLStack();
        //push and pull from thisStack to the temp stack
        //check if it's the min value by comparing to previous value
        //declare min and prev to track the smallest Value
        //as I pop from thisStack the size shrinks, set a new int to hold the current size
        int stackSize = this.getSize();
        double min;
        double smallestValue = Double.MAX_VALUE;

        //loop through stack and pop from thisStack and push that value to tempStack
        //all the while looking for the min value
        while(topOfStack != null){

            //set min to the next item in stack
            min = peek();
            //compare the next item to the prev item and if its smaller set to smallest value
            if (min < smallestValue)
                smallestValue = min;
            //push the popped value from thisStack to tempStack
            tempStack.push(this.pop());


        }
        //now push and pop from tempStack to thisStack but skip over the min value
            while(tempStack.topOfStack != null){
                //if the next item is not equal to the smallestValue then push the popped value of tempStack to thisStack
            if (tempStack.peek() != smallestValue)
                push(tempStack.pop());
            //if it is equal to the smallestValue just remove
            else {
                tempStack.pop();
            }
        }
        //push  smallestValue at the very end
        push(smallestValue);

    }

    /**
     * toString - print stack by adding values to string
     * @return stack with top and bottom markers
     */
    @Override
    public String toString() {
        String returnString ="";
        ListNode head = topOfStack;
        while (head != null) {
            returnString += head.val + " ";
            head = head.next;

        }
        return returnString;
    }

}
