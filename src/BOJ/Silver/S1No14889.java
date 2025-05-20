package BOJ.Silver;

import java.util.*;
/* =================================================
 * 14889번_스타트와 링크 - 조합으로 해결
 *
 * 풀이 시간 : 1시간 10분
 *
 * *** 회고 ***
 * 조합 알고리즘은 이번에 처음 구현해 봤다.
 * ================================================= */
public class S1No14889 {
    public static int solution(int n, int[][] power) {
        boolean[] startTeam = new boolean[n];
        return comb(n, power, startTeam, 0, n/2);
    }

    private static int comb(int n, int[][] power, boolean[] startTeam, int start, int r){
        int diff = Integer.MAX_VALUE;
        if(r == 0){
            diff = diffPower(n, power, startTeam);
        } else {
            for(int i = start; i < n; i++){
                startTeam[i] = true;
                diff = Math.min(diff, comb(n, power, startTeam, i+1, r-1));
                startTeam[i] = false;
            }
        }
        return diff;
    }

    private static int diffPower(int n, int[][] power, boolean[] startTeam){
        int startPower = 0;
        int linkPower = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(startTeam[i] && startTeam[j]){
                    startPower += power[i][j];
                } else if(!startTeam[i] && !startTeam[j]){
                    linkPower += power[i][j];
                }
            }
        }

        return startPower > linkPower ? startPower - linkPower : linkPower - startPower;
    }
}
