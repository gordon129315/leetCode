package test;

public class Apple extends Fruit {
    public void exec(Object object) {
        System.out.println("Apple object!");
    }

//    public void exec(Fruit fruit) {
//        System.out.println("Apple fruit!");
//    }

    public void exec(Apple apple) {
        System.out.println("Apple apple!");
    }

}
