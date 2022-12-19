import java.util.*;

public class 잃어버린_괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sub = sc.next().split("\\-");
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<sub.length; i++){
            String[] add = sub[i].split("\\+");

            int temp = 0;

            for(int j=0; j<add.length; j++){
                temp += Integer.parseInt(add[j]);
            }

            if(answer == Integer.MAX_VALUE){
                answer = temp;
                continue;
            }
            answer -= temp;
        }

        

        System.out.println(answer);
    }
}
