package Programmers.Level4;
import java.util.*;

/* =================================================
 * 매출 하락 최소화 - dfs 로 해결
 *
 * 풀이 시간 : ????
 *
 * *** 회고 ***
 * 이번 문제는 많이 어려웠고...
 * 최종적으로 GPT 의 도움으로 해결했다.
 *
 * dfs 방식으로 접근해야한다는 것은 파악할 수 있었지만..
 * 자신이 참석하지 않을때,
 * 팀원중 한명을 반드시 참석시키는 것을
 * 확인하기 위한 방법을 생각해내지 못해서...
 * 도움을 받았다..
 * ================================================= */
public class MinimizeSalesDecline {
    private static class Node{
        int idx;
        int sale;
        List<Node> nextNodeList;

        public Node(int idx, int sale){
            this.idx = idx;
            this.sale = sale;
            this.nextNodeList = new ArrayList<>();
        }
    }

    public static int solution(int[] sales, int[][] links) {
        int answer = 0;
        Node[] nodeList = new Node[sales.length+1];
        for(int i = 1; i < sales.length+1; i++){
            nodeList[i] = new Node(i, sales[i-1]);
        }

        for(int[] link : links){
            nodeList[link[0]].nextNodeList.add(nodeList[link[1]]);
        }

        int[] result = findMinSales(nodeList[1]);
        answer = Math.min(result[0], result[1]);
        return answer;
    }

    public static int[] findMinSales(Node parentNode){
        int[] result = new int[2];
        result[1] = parentNode.sale;
        if(parentNode.nextNodeList.isEmpty()){
            result[0] = 0;
            return result;
        }

        int childMinSale = Integer.MAX_VALUE;
        for(Node childNode : parentNode.nextNodeList){
            int[] childResult = findMinSales(childNode);
            result[1] += Math.min(childResult[0], childResult[1]);

            result[0] += Math.min(childResult[0], childResult[1]);
            childMinSale = Math.min(childMinSale, childResult[1] - Math.min(childResult[0], childResult[1]));
        }

        if(childMinSale > 0) {
            result[0] += childMinSale;
        }

        return result;
    }
}
