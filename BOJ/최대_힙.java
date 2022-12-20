package BOJ;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대_힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int order = sc.nextInt();
            if(order == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
                continue;
            }
            pq.add(order);
        }
    }
}
