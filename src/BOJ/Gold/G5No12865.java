package BOJ.Gold;

import java.util.Arrays;

/* =================================================
 * 12865번_평범한 배낭 - DP로 해결
 *
 * 풀이 시간 : 3시간
 *
 * *** 회고 ***
 * ================================================= */
public class G5No12865 {
    public static long solution(int n, int k, int[][] obj){
        //0~k 까지 무게에 대해 최대 효용(v)을 기록한다.
        long[] sumV = new long[k+1];
        Arrays.fill(sumV, 0L);
        //obj 선택했다는 전제로 이전 턴에서 효용이 부여된 무게에 대해서 현재 선택하는  obj 의 무게를 더해 해당 인덱스의 효용을 증가 시킨다.
        for(int i = 0; i < n; i++){
            int thisW = obj[i][0];
            int thisV = obj[i][1];

            if(thisW > k) continue;

            long[] thisSumV = new long[k+1];
            Arrays.fill(thisSumV, 0L);

            thisSumV[thisW] = Math.max(sumV[thisW], thisV);

            for(int j = 1; j < k+1; j++){
                if (sumV[j] == 0) continue;
                thisSumV[j] = Math.max(thisSumV[j], sumV[j]);

                if (j+thisW > k) continue;
                thisSumV[j+thisW] = Math.max(thisSumV[j+thisW], Math.max(sumV[j+thisW], sumV[j]+thisV));
            }

            sumV = thisSumV;
        }

        Arrays.sort(sumV);
        return sumV[k];
    }
}
