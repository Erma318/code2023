package Verify;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    // First [   ] Last <- 1 , [1 , ] <- 2
    // [1 , 2]
    public static void main(String[] args) {
        System.out.println("Use deque as a queue: ");
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(1);
        queue.offerLast(2);
        System.out.println(queue.peekFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.peekFirst());

        System.out.println("Use deque as a stack: ");
        Deque<Integer> stack = new LinkedList<>();
        queue.offerLast(1);
        queue.offerLast(2);
        System.out.println(queue.peekLast());
        System.out.println(queue.pollLast());
        System.out.println(queue.peekLast());
    }
}
