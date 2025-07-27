import java.util.Scanner;

public class Main {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Recursion - Factorial
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Stack using Array
    static class Stack {
        int top = -1;
        int[] stack = new int[5];

        void push(int val) {
            if (top == 4) {
                System.out.println("Stack Overflow");
                return;
            }
            stack[++top] = val;
        }

        int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top--];
        }

        void display() {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Queue using Array
    static class Queue {
        int front = 0, rear = 0;
        int[] queue = new int[5];

        void enqueue(int val) {
            if (rear == 5) {
                System.out.println("Queue Full");
                return;
            }
            queue[rear++] = val;
        }

        int dequeue() {
            if (front == rear) {
                System.out.println("Queue Empty");
                return -1;
            }
            return queue[front++];
        }

        void display() {
            System.out.print("Queue: ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array input
        int[] arr = new int[5];
        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        // Sorting
        bubbleSort(arr);
        System.out.print("Sorted Array: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Binary Search
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        int index = binarySearch(arr, key);
        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");

        // Recursion
        System.out.print("Enter number for factorial: ");
        int factNum = sc.nextInt();
        System.out.println("Factorial of " + factNum + " is: " + factorial(factNum));

        // Stack operations
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.display();
        System.out.println("Popped from stack: " + stack.pop());
        stack.display();

        // Queue operations
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.display();
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        sc.close();
    }
}
