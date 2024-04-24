package algorithm.data;

import java.util.*;

public class programer_bestsong {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    public static class Solution {

        public Solution() {
            String[] ge = { "classic", "pop", "classic", "classic", "pop", "jazz" };
            int[] py = { 500, 600, 150, 800, 2500 , 1};
            int[] res = solution(ge, py);
            for(int i : res){
                System.out.println(i);
            }
            
        }

        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> elscore = new HashMap<>();
            Map<String, Elbum> elbumMap = new HashMap<>();
            Set<String> set = new HashSet<>();
            int[] answer = {};
            for (int i = 0; i < genres.length; i++) {
                String name = genres[i];
                if (!set.contains(name)) {
                    // 처음 등록 될때 1. 앨범리스트 맵 생성, 스코어맵 생성
                    set.add(name);
                    Elbum elbum = new Elbum();
                    elbum.name = name;
                    elbum.map.put(i, plays[i]);
                    elbumMap.put(name, elbum);

                    // 재생수 순위도 정해져야 하므로
                    elscore.put(name, plays[i]);
                } else {
                    Elbum elbum = elbumMap.get(name);
                    elbum.map.put(i, plays[i]);
                    elscore.put(name, elscore.get(name) + plays[i]);
                }
            }

            // 스코어 정렬 시작
            List<String> scorelist = new ArrayList<>(elscore.keySet());
            Collections.sort(scorelist, (a, b) -> elscore.get(b) - elscore.get(a));

            List<Integer> answerlist = new ArrayList<>();
            for (String listname : scorelist) {
                Elbum elbum = elbumMap.get(listname);
                int[] temp = elbum.func();
                for (int i : temp) {
                    answerlist.add(i);
                }
            }

            answer = new int[answerlist.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerlist.get(i);
            }

            return answer;
        }

        public class Elbum {
            public String name;
            public Map<Integer, Integer> map = new HashMap<>();

            // 앨범에서 인기곡 정렬
            public int[] func() {
                int[] temp = new int[2];
                List<Integer> list = new ArrayList<>(this.map.keySet());
                if(list.size()<2){
                    int[] temp2 = {list.get(0)};
                    return  temp2;
                }
                Collections.sort(list, (a, b) -> this.map.get(b) - this.map.get(a)); // {4 , 1 , 3}
                
                for (int i = 0; i < 2; i++) {
                    temp[i] = list.get(i);
                }
                return temp;
            }
        }

    }
}
