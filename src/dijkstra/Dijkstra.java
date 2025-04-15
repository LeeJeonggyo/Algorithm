package dijkstra;
import java.util.*;

public class Dijkstra {
    /* ============================================================
     * 다익스트라(Dijkstra) 알고리즘
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
    private int[] sdArr;

    //방문 배열
    private boolean[] visitArr;

    public int[] getSdArr(){
        return this.sdArr;
    }

    /**
     * 객체를 생성하고, 넘어온 인접리스트를 사용해 최단 거리 배열을 초기화 한다.
     * @param maxValue int::
     * @param list ArrayList<int[]>[]::배열 IDX = 노드 번호 / 리스트 = new int[]{연결 노드 IDX, 엣지 value}
     * @param startNode int::시작노드 번호
     */
    public Dijkstra(int maxValue, ArrayList<int[]>[] list, int startNode){
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
        int thisSdArrIdx = startNode;
        while(thisSdArrIdx != -1){
            //찾은 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
            updateSdArr(thisSdArrIdx);
            //최단 거리 배열에서 가장 작은 값을 가진 노드를 찾는다.
            thisSdArrIdx = findMinSdArrIdx();
        }
    }

    /**
     * 최단 거리 배열을 초기화 한다.
     * @param startNode int::시작점
     */
    private void setArr(int startNode){
        // 최단 거리 배열을 초기화 한다 :: 출발노드는 0 / 이 외 노드는 무한대(최대값+1)로 초기화 해준다.
        sdArr = new int[this.nodeMax];
        Arrays.fill(sdArr, this.maxValue);
        sdArr[startNode] = 0;
    }

    /**
     * 방문할 수 있는 노드 중 최단 거리 배열에서 가장 작은 값을 가진 노드를 찾는다.
     * @return int::다음 방문해야하는 노드 인덱스 / 반환 값이 -1일 경우, 방문 가능한 노드를 모두 방문했음을 의미한다.
     */
    private int findMinSdArrIdx(){
        //3. 최단 거리 배열에서 가장 작은 값을 가진 노드를 고른다.
        //      해당 노드를 방문 처리 한다. (방문 배열을 만들어 업데이트)

        //최단 거리 배열에서 가장 작은 값을 가진 노드를 찾는다.
        int thisSdArrIdx = -1;
        int value = this.maxValue;
        for(int i = 0; i < this.nodeMax; i++){
            //방문 여부 확인
            if(this.visitArr[i]) continue;
            //미방문 데이터 중, 가장 작은 최단 거리 배열을 가진 노드를 찾는다.
            if(value > this.sdArr[i]){
                thisSdArrIdx = i;
                value = this.sdArr[i];
            }
        }
        //해당 노드를 방문 처리 한다. (방문 배열을 만들어 업데이트)
        if(thisSdArrIdx != -1) this.visitArr[thisSdArrIdx] = true;
        return thisSdArrIdx;
    }

    private void updateSdArr(int thisSdArrIdx){
        //4. 3에서 선택한 노드의 인접 리스트를 확인해서 최단 거리 배열을 업데이트 한다.
        //      "연결 노드의 최단 거리 배열의 value" 과 "3에서 선택한 최단 거리 배열의 value + 엣지 가중치" 중
        //      작은 값을 "연결 노드의 최단 거리"로 업데이트 한다.
        int sdValue = this.sdArr[thisSdArrIdx];
        ArrayList<int[]> thisList = this.list[thisSdArrIdx];
        for (int[] connect : thisList) {
            int conNode = connect[0];
            int edgeVal = connect[1];
            this.sdArr[conNode] = Math.min(this.sdArr[conNode], sdValue + edgeVal);
        }
    }

}
