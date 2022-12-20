package BOJ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 프린터_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T --> 0){
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int answer = 1;

            int n = sc.nextInt();
            int target = sc.nextInt();

            for(int i=0; i<n; i++){
                // 기존의 인덱스 저장하기
                int num = sc.nextInt();
                q.add(new int[] {i,num});
                pq.add(num);
            }

            while(!q.isEmpty()){
                int[] now = q.poll();

                if(pq.peek() == now[1]){
                    if(now[0] == target){
                        break;
                    }
                    pq.poll();
                    answer++;
                }
                else{
                    q.add(now);
                }
            }
            System.out.println(answer);
        }
    }
}
