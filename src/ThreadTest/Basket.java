package ThreadTest;

public class Basket {
//    private int[] arr;
    private int index = 0;
    private int size = 5;

    public Basket() {
//        arr = new int[5];
    }

    public synchronized void push() {
        while (index == 5) {
            try {
                System.out.println("Full!!! wait for consume...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer wake up.");
            }
        }
        index++;
        System.out.println("produce: No." + index);
        notifyAll();
    }

    public synchronized void remove() {
        while (index == 0) {
            try {
                System.out.println("Empty!!! wait for produce...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer wake up.");
            }
        }
        System.out.println("remove: No." + index);
        index--;
        System.out.println("remain --------------------- " + index);
        notifyAll();
    }
}
