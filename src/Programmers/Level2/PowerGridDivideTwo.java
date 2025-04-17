package Programmers.Level2;
import java.util.*;

/* =================================================
 * 전력망을 둘로 나누기 - 완전탐색(브루트포스) 로 해결
 *
 * 풀이 시간 : 1시간
 *
 * *** 회고 ***
 * 최근에 이진트리만을 다루면서
 * 기본 트리 문제에 문제 접근과 해결 방법 모색에서 조금 헤맸다.
 * 해당문제가 완전탐색 문제라는 것을 인지 한 이후
 * 15분 정도 소요해서 문제를 해결해낼 수 있었다.
 * ================================================= */
public class PowerGridDivideTwo {
    public static int N;
    public static ArrayList<Integer>[] nodeList;
    public static int maxConnectNodeCnt;
    public static int totalEdgeCnt;
    public static int solution(int n, int[][] wires) {
        int answer = -1;
        N = n;

        maxConnectNodeCnt = 0;
        visit = new boolean[N+1];
        totalEdgeCnt = wires.length;
        nodeList = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int[] wire : wires){
            nodeList[wire[0]].add(wire[1]);
            nodeList[wire[1]].add(wire[0]);
        }

        for(int[] wire : wires){
            Arrays.fill(visit, false);
            visit[wire[0]] = true;
            visit[wire[1]] = true;
            int thisDiff = Math.abs(count(wire[0]) - count(wire[1]));
            answer = answer == -1 ? thisDiff : Math.min(answer, thisDiff);
        }

        return answer;
    }

    private static boolean[] visit;
    private static int count(int a){
        int cntA = 0;
        visit[a] = true;
        for(int i : nodeList[a]){
            if(visit[i]) continue;
            visit[i] = true;
            cntA += 1;
            cntA += count(i);
        }

        return cntA;
    }
}
