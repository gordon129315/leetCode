/*
check if there is a loop in a graph

input:
5
101 7 8
101 9 -1
102 -1 7
102 8 -1
103 -1 9

output: YES

 */


package pct_check_deadlock;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        new Driver().run();
    }

    private void run() {
        Graph graph = new Graph();

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            scanner = new Scanner(System.in);

            String name1 = scanner.next();
            Node node1 = graph.getOrCreateNode(name1);

            String name2 = scanner.next();
            if (!name2.equals("-1")) {
                Node node2 = graph.getOrCreateNode(name2);
                node2.addNode(node1,false);
            }

            String name3 = scanner.next();
            if (!name3.equals("-1")) {
                Node node3 = graph.getOrCreateNode(name3);
                node1.addNode(node3,false);
            }

        }


        if (graph.checkDeadLock()) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }
}
