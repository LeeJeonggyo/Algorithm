package Programmers.Level3;

/* =================================================
 * 금과 은 운반하기 - 이진탐색(이분탐색)으로 해결
 *
 * 풀이 시간 : 2시간 30분
 *
 * *** 회고 ***
 * 처음 1시간 가량은 DP와 BFS 를 사용해 풀이에 접근했다.
 * 제시된 테스트 케이스들은 통과 되었으나 제출 했을때는 틀리는 문제들이 생겼다.
 * 원인은 처음 알고리즘 구현시에 금을 먼저 채우고 나머지를 은으로 채우는 방식으로 작업했는데,
 * 그렇게 되면, 은을 먼저 채우고 금으로 채워야 더 효율적인 경우가 배제 될 수 있었다.
 * 또한, DP 를 사용해서 어느 정도 시간을 줄인다고 해도
 * 입력되는 데이터가 많다는 점에서 시간초과가 발생했다.
 *
 * 해당 방법으로 풀리지 않는 다는 것을 알고,
 * 금과 은을 어떻게 분배해야 하는건지 고민을 많이 했다...
 * 1~2시간 정도 더 고민을 해봤지만.. 감이 오지 않았다.
 *
 * 그래서 구글 검색으로 다른 사람의 풀이를 확인해 이진 탐색을 어떻게 사용했는지 파악할 수 있었다.
 *
 * 금만 옮기는 값과
 * 은만 옮기는 값
 * 트럭의 전체 용량
 * 3가지를 구해서 3가지가 각각 필요량보다 많은지를 확인해 금과 은을 분배하는 문제를 해결하고 있었다.
 *
 * 이걸 생각해낼 수 있었으면 좋았겠다 싶다...
 * ================================================= */
public class GoldSilverCarry {
    static int[] needSG;
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        //새로운 도시를 짓기 위해 금 a kg 은 b kg이 필요
        //i번 도시에는 금 g[i] kg / 은 s[i] kg / 트럭 1 대 가 존재
        //편도 이동시 t[i] 시간 소요
        //각 도시의 트럭은 최대 w[i] kg 광물 운반 가능
        long start = 0;
        long end = (long) Math.pow(10, 15);
        answer = end;

        while(start <= end){
            long mid = (start+end)/2;
            if(binarySearch(mid, a, b, g, s, w, t)){ //좌측으로 이동
                answer = Math.min(answer, mid);
                end = mid-1;
            } else { //우측으로 이동
                start = mid+1;
            }
        }
        return answer;
    }

    private static boolean binarySearch(long mid, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long totalG = 0;
        long totalS = 0;
        long totalMix = 0;

        for(int i = 0; i < g.length; i++){
            long time = t[i];
            long roundTime = time*2;

            long moveCnt = mid/roundTime;
            if(mid%roundTime >= time) moveCnt++;

            long maxTake = w[i] * moveCnt;

            totalG += Math.min((long) g[i], maxTake);
            totalS += Math.min((long) s[i], maxTake);
            totalMix += Math.min((long) (g[i]+s[i]), maxTake);
        }

        return (totalG >= a && totalS >= b && totalMix >= (a+b));

    }
}
