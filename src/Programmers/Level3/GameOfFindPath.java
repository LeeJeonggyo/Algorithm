package Programmers.Level3;

import java.util.*;

/* =================================================
 * 길 찾기 게임 - 이진 트리 해결
 * ================================================= */
public class GameOfFindPath {
    private static class Node implements Comparable<Node>{
        int idx;
        int x;
        int y;
        Node left, right;
        int leftCnt, rightCnt;

        public Node(int idx, int x, int y){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
            this.leftCnt = 0;
            this.rightCnt = 0;
        }

        @Override
        public int compareTo(Node o){
            if(o.y != this.y)
                return o.y-this.y;
            return this.x-o.x;
        }
    }


    static Node root;

    public static int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[n][n];


        // 이진 트리 만들기
        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Node thisNode = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
            nodeList.add(thisNode);
        }

        Collections.sort(nodeList);

        root = nodeList.get(0);
        for(int i = 1; i < n; i++){
            setNodeTree(nodeList.get(i));
        }

        setResult(answer, root, 0, n-1);

        return answer;
    }

    private static void setNodeTree(Node thisNode){
        Node basicNode = root;

        while(true){
            if(basicNode.x > thisNode.x){
                basicNode.leftCnt += 1;
                if(basicNode.left == null) {
                    basicNode.left = thisNode;
                    return;
                } else {
                    basicNode = basicNode.left;
                }
            } else {
                basicNode.rightCnt += 1;
                if(basicNode.right == null) {
                    basicNode.right = thisNode;
                    return;
                } else {
                    basicNode = basicNode.right;
                }
            }
        }
    }

    private static void setResult(int[][] answer, Node thisNode, int index0, int index1){
        answer[0][index0] = thisNode.idx;
        answer[1][index1] = thisNode.idx;
        if(thisNode.left != null){
            setResult(answer, thisNode.left, index0+1, index1-1-thisNode.rightCnt);
        }
        if(thisNode.right != null){
            setResult(answer, thisNode.right, index0+1+thisNode.leftCnt, index1-1);
        }
    }
}
