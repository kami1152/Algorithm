package algorithm;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int number, int target) {

        Queue<Integer> que = new LinkedList<>();
        int[] arr = new int[target * 2];
        Arrays.fill(arr,0);
        int res = 0;
        arr[number] = res;
        que.offer(number);
        while (!que.isEmpty()) {
            number = que.poll();
            //System.out.println(number);
            if(number == target){
                break;
            }
            int[] dx = { number + 1, number - 1, number * 2 };
            for (int i = 0; i < 3; i++) {
                
                int nx = dx[i]; //6 4 10
                //System.out.println(nx);
                if (nx > 0 && nx < target * 2) {
                    if(arr[nx] == 0){
                        que.offer(nx);
                        arr[nx] = arr[number]+1;
                    }
                }
            }
        }

        return arr[target];

    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int number1 = 5;
        int target1 = 9;
        int ret1 = sol.solution(number1, target1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int number2 = 3;
        int target2 = 11;
        int ret2 = sol.solution(number2, target2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}