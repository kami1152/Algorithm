package algorithm.DP;

public class programers_thief {
    public static void main(String[] args) {
        Solution sol;
    }
    public class Solution{
        int[] temp = {0,0,0,0};
        int level = 0;
        public int solution(int[][] land){
            for(int[] line : land){
              for(int i = 0; i < 4 ;i ++){
                    temp[0] = Math.max(line[i-1]+line[i],temp[0]);
              }
            }

            return 0;
        }
    }
}
