package BOJ.Gold;

import java.util.*;

/* =================================================
 * 1766번_문제집 - 우선순위 큐로 해결
 *
 * 풀이 시간 : 1시간 5분
 *
 * *** 회고 ***
 * ================================================= */
public class G2No1766 {
    public static String solution(int n, int m, int[][] data){
        Node[] question = new Node[n+1];
        for(int i = 0 ;i < n+1; i++){
            question[i] = new Node(i);
        }

        for(int i = 0; i < m; i++){
            int a = data[i][0];
            int b = data[i][1];
            question[a].next.add(question[b]);
            question[b].priorCnt += 1;
        }

        for(int i = 1 ;i < n+1; i++){
            if(question[i].priorCnt == 0)
                priorSolveQuestion.add(question[i]);
        }

        StringBuilder result = new StringBuilder();
        while(!priorSolveQuestion.isEmpty()){
            Node thisNode = priorSolveQuestion.poll();
            result.append(solveQuestion(thisNode));
        }

        return result.substring(0,result.length()-1);
    }

    private static PriorityQueue<Node> priorSolveQuestion = new PriorityQueue<>();
    private static String solveQuestion(Node thisNode){
        String result = thisNode.num+" ";

        while(!thisNode.next.isEmpty()){
            Node nextNode = thisNode.next.poll();
            nextNode.priorCnt -= 1;
            if(nextNode.priorCnt == 0)
                priorSolveQuestion.add(nextNode);
        }

        return result;
    }

    private static class Node implements Comparable<Node>{
        int num;
        int priorCnt;
        PriorityQueue<Node> next;

        public Node(int num){
            this.num = num;
            this.priorCnt = 0;
            this.next = new PriorityQueue<>();
        }

        @Override
        public int compareTo(Node o){
            return this.num - o.num;
        }
    }
}
