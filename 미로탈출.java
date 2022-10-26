import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
    public static int n,m;
    public static int[][] arr = new int[300][300];
    public static int[][] visited = new int[300][300];
    public static int[] dys = {-1,1,0,0};
    public static int[] dxs = {0,0,-1,1};

    public static int solve(){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int ans = 1;

        while(q.size()>0){
            int x = q.poll();
            int y = q.poll();

            if (x==(n-1)&&y==(m-1)){
                break;
            }

            arr[x][y] = 0; // 방문했다는 뜻

            for (int i=0;i<4;i++){
                int nx = x+dxs[i];
                int ny = y+dys[i];
                if (nx<n && ny<m && ny>=0 && nx>=0 && arr[nx][ny]==1 && (nx > x || ny > y)){
                    ans++;
                   q.add(nx);
                   q.add(ny);
                }
            }


        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            for(int j=0;j<m;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        int ans = solve();
        System.out.println(ans);


        /*
         괴물이 있는 부분은 0
         괴물이 없는 부분은 1
         최단경로를 구해야 함 -> bfs
         */
    }
}
