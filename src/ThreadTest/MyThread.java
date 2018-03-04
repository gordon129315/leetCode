package ThreadTest;

public class MyThread extends Thread {
//    private String name;

    public MyThread(String name) {
        super(name);
    }

    public void run(){
        int i = 0;
        while (i ++ < 10) {
            System.out.println("i:" + i + " name:" + getName() + " 子线程ID:" + Thread.currentThread().getId() + " 子线程名字:" + Thread.currentThread().getName());
            try {
                Thread.currentThread().join(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() +" sleep over");
        }
    }
}
