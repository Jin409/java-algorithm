import java.util.Arrays;
import java.util.Scanner;

public class 연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(); // 개수
        int[] nums = new int[l];
        int[] dp = new int[l];
        for(int i=0;i<l;i++){
            nums[i] = sc.nextInt();
        }
        dp[0] = nums[0];

        for(int i=1; i<l; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        Arrays.sort(dp);
        System.out.println(dp[l-1]);
    }
}
