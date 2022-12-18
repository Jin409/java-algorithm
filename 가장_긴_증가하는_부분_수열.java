import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 가장_긴_증가하는_부분_수열 {
    public static int solve(int index, int l, int[] nums, Stack<Integer> s, int[] dp) {
        if (index == l) {
            Arrays.sort(dp);
            return dp[l - 1];
        }

        // 증가하는 부분일 경우
        if (s.isEmpty() || (nums[index] > s.peek() && dp[index] < s.size())) {
            // 해당 숫자를 추가하는 경우
            s.add(nums[index]);
            solve(index + 1, l, nums, s, dp);
            if (dp[index] < s.size()) {
                dp[index] = s.size();
            }
            // 해당 숫자를 포함하지 않는 경우
            s.pop();
        }
        return solve(index + 1, l, nums, s, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int l = sc.nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solve(0, l, nums, new Stack<>(), new int[l]));
    }
}
