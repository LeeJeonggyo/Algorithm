package Algorithm.dijkstra;

import java.util.*;

public class Dijkstra_PriorityQ {
    /* ============================================================
     * 다익스트라(Dijkstra) 알고리즘 - 우선순위 큐 사용해서 구현
     *
     * DP(다이나믹 프로그래밍)를 활용한 "최단 경로 탐색" 알고리즘
     * 한 정점(시작점)에서 모든 정점 까지의 최단 거리를 구한다.
     *
     * 시간복잡도 : O(ElogV)  (E::엣지 수 / V::노드 수)
     *
     * [특징]
     * 시작점 O
     * 음수 엣지(간선) X
     * 그래프 방향의 유무 상관 없음.
     * ============================================================*/

    //1. 인접 리스트를 구현한다.
    private int nodeMax;
    private ArrayList<int[]>[] list; // 배열 IDX = 노드 번호 / 리스트 = new int[]{연결 노드 IDX, 엣지 value}
    //2. 최단 거리 배열을 초기화 한다 :: 출발노드는 0 / 이 외 노드는 무한대(최대값+1)로 초기화 해준다.
    private int maxValue;
    private Node[] sdArr;

    //방문 배열
    private boolean[] visitArr;

    public static class Node implements Comparable<Node>{
        public int conNode;
        public int sdValue;
        public Node(int conNode, int sdValue){
            this.conNode = conNode;
            this.sdValue = sdValue;
        }

        @Override
        public int compareTo(Node o){
            return this.sdValue - o.sdValue;
        }
    }

    /**
     * 객체를 생성하고, 넘어온 인접리스트를 사용해 최단 거리 배열을 초기화 한다.
     * @param maxValue int::
     * @param list ArrayList<int[]>[]::배열 IDX = 노드 번호 / 리스트 = new int[]{연결 노드 IDX, 엣지 value}
     * @param startNode int::시작노드 번호
     */
    public Dijkstra_PriorityQ(int maxValue, ArrayList<int[]>[] list, int startNode){
        this.nodeMax = list.length;
        this.maxValue = maxValue+1;
        this.list = list;
        visitArr = new boolean[this.nodeMax]; //방문 배열을 초기화 한다.
        setResult(startNode);
    }

    //3. 최단 거리 배열에서 가장 작은 값을 가진 노드를 고른다.
    //      해당 노드를 방문 처리 한다. (방문 배열을 만들어 업데이트)
    //4. 3에서 선택한 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
    //      "3에서 선택한 최단 거리 배열의 value + 엣지 가중치" 와 "연결 노드의 최단 거리 배열의 value" 중
    //      작은 값을 "연결 노드의 최단 거리"로 업데이트 한다.
    //5. 3번 & 4번 과정을 모든 노드를 다 방문할때까지 반복한다.
    public void setResult(int startNode){
        //최단 거리 배열 초기화
        setArr(startNode);
        //모든 노드를 다 방문할때까지 반복한다.
        while(!pq.isEmpty()){
            //최단 거리 배열에서 가장 작은 값을 가진 노드를 추출하고, 방문 처리를 한다.
            Node thisSdArrIdx = pq.poll();
            visitArr[thisSdArrIdx.conNode] = true;

            //찾은 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
            updateSdArr(thisSdArrIdx);
        }
    }

    /**
     * 최단 거리 배열을 초기화 한다.
     * @param startNode int::시작점
     */
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    private void setArr(int startNode){
        // 최단 거리 배열을 초기화 한다 :: 출발노드는 0 / 이 외 노드는 무한대(최대값+1)로 초기화 해준다.
        sdArr = new Node[this.nodeMax];
        for(int i = 0; i < this.nodeMax; i++){
            sdArr[i] = new Node(i, (i == startNode) ? 0 : this.maxValue);
            pq.add(sdArr[i]);
        }
    }

    private void updateSdArr(Node thisSdArrIdx){
        //4. 3에서 선택한 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
        //      "연결 노드의 최단 거리 배열의 value" 과 "3에서 선택한 최단 거리 배열의 value + 엣지 가중치" 중
        //      작은 값을 "연결 노드의 최단 거리"로 업데이트 한다.
        ArrayList<int[]> thisList = this.list[thisSdArrIdx.conNode];
        for (int[] connect : thisList) {
            int conNode = connect[0];
            int edgeVal = connect[1];
            this.sdArr[conNode].sdValue = Math.min(this.sdArr[conNode].sdValue, thisSdArrIdx.sdValue + edgeVal);
        }
    }

    public Node[] getSdArr(){
        return this.sdArr;
    }
}
