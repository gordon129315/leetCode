/*
https://leetcode.com/problems/task-scheduler/description/
621. Task Scheduler
 */

package leetcode_621;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, 1 + map.getOrDefault(task, 0));
        }

        LinkedList<Character> orderList = sortMap(map);

        LinkedList<Character> taskList = new LinkedList<>();

        while (orderList.size() != 0) {
            int interval = 0;
            for (char c : orderList) {
                taskList.add(c);
                map.put(c, map.get(c) - 1);
                interval++;
                if (interval == n + 1) {
                    break;
                }
            }
            if (interval < n + 1) {
                int gap = n + 1 - map.size();
                for (int i = 0; i < gap; i++) {
                    taskList.add('-');
                }
            }
            removeZeros(map, orderList);
            orderList = sortMap(map);
//            System.out.println(orderList);
        }

        while (taskList.getLast() == '-') {
            taskList.removeLast();
        }

        System.out.println(taskList);

        return taskList.size();
    }

    private LinkedList<Character> sortMap(Map<Character, Integer> map) {
        LinkedList<Character> keyList = new LinkedList<>();
        LinkedList<Integer> valueList = new LinkedList<>();

        valueList.addAll(map.values());
        Collections.sort(valueList);
        Collections.reverse(valueList);
//        System.out.println(valueList);

        for (int i : valueList) {
            for (char c : map.keySet()) {
                if (map.get(c) == i) {
                    if (!keyList.contains(c)) {
                        keyList.add(c);
                        break;
                    }
                }
            }
        }
//        System.out.println(keyList);
        return keyList;
    }

    private void removeZeros(Map<Character, Integer> map, LinkedList<Character> orderList) {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() == 0) {
                orderList.remove(next.getKey());
                iterator.remove();
            }
        }
    }

}
