package BOJ.Gold;
import java.util.*;

/* =================================================
 * 1253번_좋다 - 투포인터 해결
 *
 * 풀이 시간 : ??
 *
 * *** 회고 ***
 * 데이터 값으로 음수도 가능하다는 사실을 놓쳐서 헤맸던 문제...
 * 조건을 좀 더 자세히 확인하자.
 * ================================================= */
public class G4No1253 {
    public static int solution(int n, long[] data){

        int result = 0;

        // n : 수의 개수 N(1 ≤ N ≤ 2,000)
        // data : i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수), 음수 가능


        //1. data 오름차순 정렬
        Arrays.sort(data);

        //2. 2번째 인덱스 위치부터 앞에 숫자를 더해 본인 값이 될 수 있는지 확인한다.
        for(int i = 0 ; i < n; i++){
            long thisNum = data[i];

            int leftIdx = 0;
            int rightIdx = n-1;
            while(leftIdx < rightIdx){
                if(leftIdx == i) {
                    leftIdx++;
                    continue;
                }

                if(rightIdx == i) {
                    rightIdx--;
                    continue;
                }

                long add = data[leftIdx] + data[rightIdx];
                if(thisNum == add) {
                    result++;
                    break;
                } else if(thisNum < add){
                    rightIdx--;
                } else {
                    leftIdx++;
                }
            }
        }


        return result;
    }
}
