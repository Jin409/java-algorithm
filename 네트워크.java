class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        this.visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++){
            
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int start){
        visited[start] = true;
        
        for(int i=0;i<n;i++){
            if(computers[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
