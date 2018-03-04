package ThreadTest;


public class RunnableDrive {
    public static void main(String[] args) {
        new RunnableDrive().run();
    }

    public void run() {
        MyRunnable run = new MyRunnable();
        Thread thread1 = new Thread(run, "thread_1");
        Thread thread2 = new Thread(run, "thread_2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
//            thread2.join();
        } catch (InterruptedException e) {
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println("----------------" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }
//
//        }

    }


}
