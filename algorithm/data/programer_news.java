package algorithm.data;

import java.util.*;

public class programer_news {

    public static void main(String[] args) {
        String a = "FRANCE";
        String b = "french";
        Solution s = new Solution();
        int x = s.solution(a, b);
        System.out.println(x);
    }

    // ab ba ab
    // ba ab ba
    // 2 3
    public static class Solution {
        static List<String> intersection = new ArrayList<>();
        static List<String> unionsection = new ArrayList<>();

        public List<String> createSet(String str1) {
            str1 = str1.toUpperCase();
            List<String> set1 = new LinkedList<>();
            for (int i = 1; i < str1.length(); i++) {
                char a = str1.charAt(i);
                char b = str1.charAt(i - 1);
                if (Character.isLetter(a) && Character.isLetter(b)) {
                    String temp = String.valueOf(a) + String.valueOf(b);
                    set1.add(temp);
                }

            }
            return set1;
        }

        public int solution(String a, String b) {
            int answer = 0;
            InterSection(a, b);

            double res = (double)intersection.size() / (double)unionsection.size() ;
            System.out.println(res);
            answer = (int) (res* 66536);
            return answer;
        }

        public void InterSection(String a, String b) {
            List<String> str1 = createSet(a); // ab bc cd de
            List<String> str2 = createSet(b);// ac ad de

            for (String item : str1) {
                if (str2.remove(item)) {
                    intersection.add(item);
                }
                unionsection.add(item);
            }
            for (String item : str2) {
                unionsection.add(item);
            }
            System.out.println(intersection);
            System.out.println(unionsection);
        }

    }

}