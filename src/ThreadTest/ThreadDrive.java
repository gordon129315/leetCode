package ThreadTest;

public class ThreadDrive {
    public static void main(String[] args) {
        new ThreadDrive().run();
    }

    public void run() {
//        System.out.println("主线程ID:"+Thread.currentThread().getId());
//        System.out.println("主线程name:"+Thread.currentThread().getName());

        MyThread thread1 = new MyThread("thread1_name");
        MyThread thread2 = new MyThread("thread2_name");
        thread1.start();
        thread2.start();
    }
}
