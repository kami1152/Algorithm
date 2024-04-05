package algorithm.data;
import java.util.*;
public class back_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 1;
        Map <String, Integer> map = new HashMap<>();
        for(int i = 0; i < 3 ; i ++ ){
            long n = Integer.parseInt(sc.nextLine());
            sum *= n;
        }
        for(int i = 0 ; i <= 9 ; i++){
            map.put(String.valueOf(i), 0);
        }
        String str = String.valueOf(sum);

        for(char c : str.toCharArray()){
            String s = String.valueOf(c);
            map.put(s, map.get(s)+1);
        }
        for(int i = 0 ; i <= 9 ; i++){
            System.out.println(map.get(String.valueOf(i)));
        }
        
    }
}
