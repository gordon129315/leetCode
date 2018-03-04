package ThreadTest;

public class ProducerConsumer {
    public static void main(String[] args) {
        new ProducerConsumer().run();
    }

    public void run() {
        Basket b = new Basket();
        Thread producer = new Thread(new Producer(b));
        Thread consumer = new Thread(new Consumer(b));

        producer.start();

        consumer.start();

    }
}
