package ua.advanced.practice3.task5;

public class Main {
    public static void main(String[] args) {
        MedianQueue queue = new MedianQueue();
        queue.offer(0);
        queue.offer(1);
        queue.offer(3);
        queue.offer(10);
        queue.offer(2);

        System.out.println(">Queue after pushing new elements: ");
        System.out.println(queue);

        System.out.println("\n>Pulled out element: " + queue.poll());
        System.out.println(">Queue after pulling: ");
        System.out.println(queue);

        System.out.println("\n>Result of getting element from the top of the queue: " + queue.peek());
        System.out.println(">Queue after getting: ");
        System.out.println(queue);

        System.out.println("\n>Output by iterator: ");
        for (int value : queue) {
            System.out.print(value + ", ");
        }

        System.out.println("\n>Queue size: " + queue.size());
    }
}
