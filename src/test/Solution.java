package test;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2);
        list1.add(5);
        System.out.println(list1);
        Integer i = 2;
        list1.remove(i);
        System.out.println(list1);

        System.out.println();

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("2");
        list2.add("5");
        System.out.println(list2);
        list2.remove("2");
        System.out.println(list2);

        System.out.println();

        LinkedList<Character> list3 = new LinkedList<>();
        list3.add('1');
        list3.add('2');
        list3.add('3');
        list3.add('2');
        list3.add('5');
        System.out.println(list3);
        Character c = '2';
        list3.remove(c);
        System.out.println(list3);
    }
}
