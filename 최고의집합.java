import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        if(n>s){
            return new int[] {-1};
        }
        
        answer = new int[n];
        
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        System.out.println("=====");
        int i = 0;
        
        while(s>0) {
            answer[(i%n)]++;
            i++;
            s--;
         }
        
        Arrays.sort(answer);
        return answer;
    }
}