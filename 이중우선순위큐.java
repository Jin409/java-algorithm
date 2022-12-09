import java.util.*;

class Solution{
    public int[] solution(String[] operations) {
        List<Integer> pq = new ArrayList<>();
        
        for(String s : operations){
            System.out.println(pq);
            
            String[] order = s.split(" ");
            
            if(order[0].equals("I")){
                int add_num = Integer.parseInt(order[1]);
                pq.add(add_num);
                Collections.sort(pq);
                continue;
            }
            
            if(pq.size()==0){
                continue;
            }
            
            // 최솟값 삭제
            else if(order[1].equals("-1")){
                pq.remove(0);
                continue;
            }
            pq.remove(pq.size()-1);
        }
        
        int[] answer;
        
        if(pq.size()==0){
            answer = new int[] {0,0};
        }
        else{
            answer = new int[] {pq.get(pq.size()-1),pq.get(0)};
        }
        return answer;
    }
}
