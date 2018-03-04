package ThreadTest;

public class Consumer implements Runnable {
    private Basket b;

    public Consumer(Basket b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            b.remove();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
