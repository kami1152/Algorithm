package algorithm;
class Solution {
=
    public void solution() {
    
        int[][] arr = {{0,2,1,3},{2,0,4,5},{3,4,0,5},{2,3,4,0}};

        int a[][] = new int[4][4];

        for(int k =0;k<4;k++){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4 ; j++){
                    if(arr[i][k] +arr[k][j]<arr[i][j]){
                        arr[i][j] = arr[i][k] + d[k][j];
                    }
                }
            }
        }
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        String ret = sol.solution(n);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}