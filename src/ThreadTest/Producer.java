package ThreadTest;

public class Producer implements Runnable {
    private Basket b;

    public Producer(Basket b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            b.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
