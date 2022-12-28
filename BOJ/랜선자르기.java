package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class 랜선자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[k];

        for(int i=0; i<k; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int start = 1;
        int end = nums[k-1];

        while(start <= end){
            int count = 0;
            int middle = (start+end)/2;

            for(int num:nums){
                count += num/middle;
            }
            if(count < n){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        System.out.println((start+end)/2);
    }
}
