

public class Main {

    public static void main(String[] args) {

        LLStack myStack = new LLStack<>();
        myStack.push(4);
        myStack.push(2);
        myStack.push(8);
        myStack.push(3);
        myStack.push(6);
        myStack.push(5);


        System.out.println("Original Stack");
        System.out.println(myStack);
        System.out.println();
        myStack.smallestToTop();
        System.out.println("New Stack");
        System.out.println(myStack);


    }

}
