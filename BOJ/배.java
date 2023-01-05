package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 배 {
    public static int solve(int n, int[] cranes, int m, int[] boxes){
        int ans = 0;

        // 박스를 옮길 수 없는 경우
        if(boxes[m-1] > cranes[n-1]){
            return -1;
        }

        int[][] dp = new int[n][m];

        for(int i=n-1; i>=0; i--){

        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 크레인의 개수 -> 1분에 하나씩 실을 수 있음
        int[] cranes = new int[n];
        for(int i=0; i<n; i++){
            cranes[i] = sc.nextInt();
        }

        int m = sc.nextInt(); // 박스의 개수
        int[] boxes = new int[m]; // 각 박스의 무게
        for(int i=0; i<m; i++){
            boxes[i] = sc.nextInt();
        }

        Arrays.sort(cranes);
        Arrays.sort(boxes);

        System.out.println(solve(n, cranes, m, boxes));
    }
}
