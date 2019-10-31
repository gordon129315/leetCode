package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

        LinkedList<Integer> list2 = deepCopy(list1);

        Iterator<Integer> iter = list1.iterator();
        while (iter.hasNext()){
            Integer next = iter.next();
            if (next == 2) {
                iter.remove();
                break;
            }
        }

        System.out.println(list1);
        System.out.println(list2);

        System.out.println();

    }

    public LinkedList<Integer> deepCopy(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (Integer i : list) {
            newList.add(i);
        }
        return newList;
    }
}
