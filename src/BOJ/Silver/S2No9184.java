package BOJ.Silver;

import java.io.*;
import java.util.*;

/* =================================================
 * 9184번_신나는 함수 실행 - DP로 해결
 *
 * 풀이 시간 : 25분
 *
 * *** 회고 ***
 * ================================================= */
public class S2No9184 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] dp = new int[21][21][21];
        for(int a = 0; a < 21; a++){
            for(int b = 0; b < 21; b++){
                for(int c = 0; c < 21; c++){
                    if(a == 0 || b == 0 || c == 0)
                        dp[a][b][c] = 1;
                    else if(a < b && b < c){
                        dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
                    } else {
                        dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
                    }
                }
            }
        }


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int result;
            if(a == -1 && b == -1 && c == -1) break;
            else if(a <= 0 || b <= 0 || c <= 0)
                result = 1;
            else if(a > 20 || b > 20 || c > 20)
                result = dp[20][20][20];
            else
                result = dp[a][b][c];

            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,result);
        }
    }
}
