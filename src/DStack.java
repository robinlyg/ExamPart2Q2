
public interface DStack<E> {
    //returns ture if stack is empty, false otherwise
    boolean isEmpty();

    //adds d to the top of the stack
    void push(double d);

    //returns and removes the value on top of stack
    //@throws EmptyStackException if stack is empty
    double pop();

    //returns (but does not remove) the value on top of stack
    //@throws emptyStackException if stack is empty
    double peek();


}
