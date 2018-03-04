package test;

public class Drive {

    public static void main(String[] args) {
        new Drive().run();
    }

    public void run() {
        Apple apple = new Apple();
        Fruit fruit = apple;
        Object object = apple;
        apple.exec( object);
    }
}
