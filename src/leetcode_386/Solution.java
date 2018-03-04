
/*
https://leetcode.com/problems/lexicographical-numbers/description/
386. Lexicographical Numbers
 */

package leetcode_386;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        int n =5000000;
        System.out.println(lexicalOrder(n));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new LinkedList();
        if (n == 0) {
            return list;
        }
        int value = 1;
        for (int i = 0; i < n; i++) {
            list.add(value);
            if (value * 10 <= n) {
                value *= 10;
            }
            else if (value * 10 > n) {
                if ((value % 10 == 9 && value != 9) || (value + 1 > n)){
                    value = (value / 10) + 1;
                    while (value % 10  == 0) {
                        value /= 10;
                    }
                }
                else {
                    value ++;
                }
            }
        }
        return list;
    }
}
