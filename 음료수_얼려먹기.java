import java.util.*;

//얼음 얼려먹기 -> 너비 우선 탐색

public class 음료수_얼려먹기 {
    public static int n, m;
    public static int arr[][] = new int[1000][1000];
    public static int dxs[] = {-1,1,0,0};
    public static int dys[] = {0,0,-1,1};

    public static boolean in_range(int x, int y){
        return x<n && y<n && x>=0 && y>=0;
    }


    public static boolean solve(int x, int y) {

        if(!in_range(x,y)){
            return false;
        }

        if (arr[x][y] == 1) {
            return false;
        }

        arr[x][y] = 1;

        for(int i=0;i<4;i++){
            int nx = x+dxs[i];
            int ny = y+dys[i];
            solve(nx,ny);
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(i,j)){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
