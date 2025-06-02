package Programmers.Level3;

import java.util.*;
/* =================================================
 * 단어변환 - 다익스트라 알고리즘으로 해결 -> BFS 로 구현하는것도 가능하다.
 * ================================================= */
public class ChangeWord {
    static String[] wordArr; // 단어
    static ArrayList<int[]>[] list; //인접리스트
    static boolean[] visitArr; //방문배열
    static int[] shortDistanceArr; //최단 거리 배열
    private static class Node implements Comparable<Node>{
        int idx;
        int shortDistance;

        public Node(int idx, int shortDistance){
            this.idx = idx;
            this.shortDistance = shortDistance;
        }

        @Override
        public int compareTo(Node o){
            return this.shortDistance - o.shortDistance;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        //1. 데이터 초기화
        //1-1. 인접리스트 생성
        wordArr = new String[words.length+1];

        wordArr[0] = begin;
        list = new ArrayList[words.length+1];
        list[0] = findNextWord(begin, words);

        int targetIdx = -1;
        for(int i = 0; i < words.length; i++){
            String thisWord = words[i];
            wordArr[i+1] = thisWord;
            list[i+1] = findNextWord(thisWord, words);
            if(target.equals(thisWord)) targetIdx = i+1;
        }

        //1-2. 방문배열 초기화
        visitArr = new boolean[words.length+1];

        //1-3. 최단 거리 배열 초기화
        setShortDistanceArr();

        //2. 다익스트라 알고리즘 구현 및 결과 찾기
        if(targetIdx != -1){
            boolean fin = dijkstra(targetIdx);
            answer = fin ? shortDistanceArr[targetIdx] : 0;
        }

        return answer;
    }

    // 본인과 1글자만 다른 단어 리스트 생성
    private static ArrayList<int[]> findNextWord(String stand, String[] words){
        ArrayList<int[]> result = new ArrayList<>();

        char[] standCharArr = stand.toCharArray();
        for(int j = 0 ; j < words.length; j++){
            int cnt = 0;
            char[] wordCharArr = words[j].toCharArray();
            for(int i = 0 ; i < standCharArr.length; i++){
                if(standCharArr[i] != wordCharArr[i]) cnt++;
            }
            if(cnt == 1) result.add(new int[] {j+1, 1});
        }

        return result;
    }

    // 최단 거리 배열 초기화
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    private static void setShortDistanceArr(){
        shortDistanceArr = new int[wordArr.length];
        Arrays.fill(shortDistanceArr, Integer.MAX_VALUE);
        shortDistanceArr[0] = 0;
        pq.add(new Node(0,0));
    }

    //다익스트라 알고리즘 구현
    private static boolean dijkstra(int targetIdx){
        boolean result = false;

        //모든 노드를 다 방문할때까지 반복한다.
        while(!pq.isEmpty()){
            //최단 거리 배열에서 가장 작은 값을 가진 노드를 추출하고, 방문 처리를 한다.
            Node thisShortDistanceNode = pq.poll();
            if (visitArr[thisShortDistanceNode.idx]) continue;
            visitArr[thisShortDistanceNode.idx] = true;

            if(thisShortDistanceNode.idx == targetIdx) result = true;

            //찾은 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
            updateShortDistanceArr(thisShortDistanceNode);
        }

        return result;
    }

    private static void updateShortDistanceArr(Node thisShortDistanceNode){
        ArrayList<int[]> thisList = list[thisShortDistanceNode.idx];
        for (int[] connect : thisList) {
            int conNode = connect[0];
            int edgeVal = connect[1];
            if(shortDistanceArr[conNode] > thisShortDistanceNode.shortDistance + edgeVal){
                shortDistanceArr[conNode] = thisShortDistanceNode.shortDistance + edgeVal;
                pq.add(new Node(conNode, shortDistanceArr[conNode]));
            }
        }
    }
}
