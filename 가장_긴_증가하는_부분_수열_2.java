import java.util.Arrays;
import java.util.Scanner;

public class 가장_긴_증가하는_부분_수열_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int l = sc.nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[l];
        Arrays.fill(dp, 1);

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[l-1]);
    }
}
