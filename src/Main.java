import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> theStack = new Stack<>();
        Queue<Integer> theQueue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int count = 0; // Used for getting the length of an array.

        while (count <= 0) {
            System.out.print("How many values would you like to enter? ");
            try {
                count = scan.nextInt();

                if (count <= 0) {
                    System.out.println("Number of values must be greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("You must enter a valid integer.");
                scan.nextLine();
            }
        }

        // Declare the array
        int[] theArray = new int[count];

        // Get values for each index.
        for (int i = 0; i < count; i++) {
            int number;
            System.out.print("Enter a number: ");
            try {
                number = scan.nextInt();
                theArray[i] = number;
                theStack.push(number);
                theQueue.add(number);
            } catch (Exception e) {
                System.out.println("You must enter a valid integer.");
                scan.nextLine();
                i--;
            }
        }

        // Display the original collections
        System.out.println("\nOriginal collections:");
        System.out.print("The array: ");
        printArray(theArray);
        System.out.print("The stack: ");
        printStack(theStack);
        System.out.print("The queue: ");
        printQueue(theQueue);

        // Reverse the collections and print them

        reverseArray(theArray);
        reverseQueue(theQueue);
        reverseStack(theStack);

        System.out.println("\nReversed collections:");
        System.out.print("The array: ");
        printArray(theArray);
        System.out.print("The stack: ");
        printStack(theStack);
        System.out.print("The queue: ");
        printQueue(theQueue);

    }

    // Helper methods to print collections

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printStack(Stack<Integer> stack) {
        for (int n : stack) {
            System.out.print(n + " ");
        }
    }

    public static void printQueue(Queue<Integer> queue) {
        for (int n : queue) {
            System.out.print(n + " ");
        }
    }

    // Helper methods to reverse collections

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Increment inwards
            left++;
            right--;
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        Queue<Integer> tempStack = new LinkedList<>();

        while (!stack.isEmpty()) {
            tempStack.add(stack.pop());
        }
        while (!tempStack.isEmpty())
            stack.push(tempStack.poll());
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> tempQueue = new Stack<>();
        while (!queue.isEmpty()) {
            tempQueue.push(queue.poll());
        }
        while (!tempQueue.isEmpty())
            queue.add(tempQueue.pop());
    }

}
