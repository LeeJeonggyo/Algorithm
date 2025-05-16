package BOJ.Silver;

/* =================================================
 * 1253번_좋다 - 투포인터 해결
 *
 * 풀이 시간 : 40분
 *
 * *** 회고 ***
 * 데이터 타입에 유의해서 작업하자.
 * long 타입...
 * ================================================= */
public class S1No6236 {

    public static long solution(int n, int m, long[] data){
        long k = 0;
        // n : 금액 사용 일 수
        // k : 한번에 인출 가능한 금액 (최소 k를 구하라)
        // m : 통장에서 인출 가능한 횟수

        long left = 1;
        long right = n*10000L+1;

        while(left < right){
            long mid = (left+right)/2;
            if(usingCoin(mid, m, data)){
                // ture :: mid 값으로 조건을 모두 만족 그러므로 mid 값을 줄여도 됨.
                right = mid;
                k = mid;
            } else {
                // false :: mid 값으로 조건을 만족하지 못함 그러므로 mid 값을 늘려야 함.
                left = mid+1;
            }
        }

        return k;
    }

    private static boolean usingCoin(long k, int m, long[] data){
        int cnt = 0;
        long reCoin = 0;
        for(long price : data){
            if(price > k) return false;

            if(price > reCoin){
                cnt++;
                reCoin = k - price;
            } else {
                reCoin -= price;
            }
        }

        return (cnt <= m);
    }

}
