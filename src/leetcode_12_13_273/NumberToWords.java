/*
https://leetcode.com/problems/integer-to-english-words/description/
273. Integer to English Words

 */

package leetcode_12_13_273;


public class NumberToWords {
    public static void main(String[] args) {
        new NumberToWords().run();
    }

    public void run() {
        System.out.println(Integer.MAX_VALUE);
        int num = 2147483647;
        System.out.println(numberToWords(1010200));
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int[] dividers = {1, 1000, 1000000, 1000000000};
        String[] units = {"", "Thousand ", "Million ", "Billion "};
        String[] tens  = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] digit = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
                          "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

        StringBuilder sb = new StringBuilder();

        for (int i = dividers.length - 1; i >= 0 ; i--) {
           if (num / dividers[i] >0) {
               int part_num = num / dividers[i];
               if (part_num / 100 > 0) {
                   sb.append(digit[part_num / 100]).append("Hundred ");
                   part_num %= 100;
               }
               if (part_num / 10 >= 2) {
                   sb.append(tens[part_num / 10]).append(digit[part_num % 10]);
               }
               else {
                   sb.append(digit[part_num]);
               }
               sb.append(units[i]);
               num %= dividers[i];
           }
        }


        return sb.toString().trim();
    }
}
