package Programmers.Level2;
/* =================================================
 * 하노이의 탑 - 재귀로 해결
 *
 * 풀이 시간 : 1시간 58분
 *
 * *** 회고 ***
 * 그 과정에서 나열해 놓은 2 <= n <= 4일 때의 경우들을 살펴보다가
 * 하노이의 탑의 최소 이동 횟수는
 * N번째 이동 횟수 = 2*(N-1번째 이동 횟수)+1 이라는 것을 파악할 수 있었다.
 *
 * 그 후... 순환 탐색으로 찾아야 한다고 생각해서 1시간 정도를 헤맸다가...
 *
 * n 번쩨는 1에서 3으로 무조건 한번만 이동한다는 것을 인지 했고,
 * n-1 번째는 n 번째의 이동 기점으로 전 후 중간 지점에서 1번씩 이동해서
 * 총 2번 이동한다는 것을 인지했다.
 *
 * 여기서 재귀 사용의 가능성을 파악해 재귀로 구현하여 문제를 해결할 수 있었다.
 * ================================================= */
public class TowerOfHanoi {
    static int N;
    static int[][] answer;
    public static int[][] solution(int n) {
        int[] size = new int[16];
        size[1] = 1;
        for(int i = 2; i < 16; i++){
            size[i] = size[i-1] * 2 + 1;
        }

        N = n;
        answer = new int[size[n]][2];
        makeAnswer(0, size[n]-1, 1,3,2);
        return answer;
    }

    private static void makeAnswer(int min, int max, int s, int e, int other){
        int mid = (min+max)/2;
        answer[mid] = new int[]{s, e};
        if(min == max) return;
        makeAnswer(min, mid-1, s, other, e);
        makeAnswer(mid+1, max, other, e, s);
    }

}
