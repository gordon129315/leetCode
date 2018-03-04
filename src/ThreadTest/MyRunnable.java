package ThreadTest;


public class MyRunnable implements Runnable {
    @Override
    public void run() {
        exec();
    }

    public void exec() {
        int i = 0;
        for (int j = 0; j < 10; j++) {
            i++;
            System.out.println(i + ": " + Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted!");
            }

        }

    }
}
