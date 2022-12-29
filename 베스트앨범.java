import java.util.*;

class 베스트앨범 {
    public String findMaxKey(Map<String, List<Integer>> map, String[] genres){
        int maxValue = 0;
        String maxKey = "";
        
        for(String key: map.keySet()){
            int value = map.get(key).get(0);
            if(value > maxValue){
                maxValue = value;
                maxKey = key;
            }
        }
        return maxKey;
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int l = genres.length;
        int index = 0;
        
        // 모든 값 해시에 넣기
        for(int i=0; i<l; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], new ArrayList<>());
                map.get(genres[i]).add(plays[i]); // 맨 앞은 합으로 두기
                map.get(genres[i]).add(plays[i]);
                continue;
            }
            map.get(genres[i]).set(0, map.get(genres[i]).get(0)+plays[i]);
            map.get(genres[i]).add(plays[i]);
        }
        
        // answer 의 길이 세팅하기
        int count = 0;
        for(List<Integer> value: map.values()){
            if(value.size() == 2){
                count++;
                continue;
            }
            count+=2;
        }
        int[] answer = new int[count];
        
        for(int i=0; i<map.size(); i++){
            String maxKey = findMaxKey(map, genres);
            List<Integer> values = map.get(maxKey);
            map.get(maxKey).set(0,0);
            
            for(int j=0; j<values.size(); j++) pq.add(values.get(j)); // 우선순위 큐에 추가
            
            // 해당 장르에 속하는 노래가 1개인 경우
            if(values.size() == 2){
                int value = pq.poll();
                for(int k=0; k<l; k++){
                    if(genres[k].equals(maxKey) && plays[k] == value){
                        answer[index] = k;
                        plays[k] = 0;
                    }
                }
                continue;
            }
            
            // 해당 장르에 속하는 노래가 2개 이상인 경우
            for(int j=0; j<2; j++){
                int value = pq.poll();
                boolean flag = false;
                for(int k=0; k<l; k++){
                    if(!flag && genres[k].equals(maxKey) && plays[k] == value){
                        answer[index] = k;
                        plays[k] = 0;
                        flag = true;
                    }
                }
                flag = true;
                index++;
            }
            pq.clear();
        }
        return answer;
    }
}