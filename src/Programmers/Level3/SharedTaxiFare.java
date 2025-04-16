package Programmers.Level3;
import Algorithm.dijkstra.Dijkstra;
import Algorithm.dijkstra.Dijkstra_PriorityQ;

import java.util.*;
/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72413">
 * 프로그래머스 > 2021 KAKAO BLIND RECRUITMENT > 합승 택시 요금
 * </a>
 */
public class SharedTaxiFare {
    static final int MAX_VAL = 20000001;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        // n :: 지점 개수 / s ::시작 지점 / a :: 도착 위치 / b :: 도착 위치
        // fares :: 배열의 각 행은 [c, d, f]로 구성 :: c 지점과 d 지점 사이의 예상 택시요금이 f원

        int answer = MAX_VAL;
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] fare : fares){
            int thisC = fare[0];
            int thisD = fare[1];
            int thisF = fare[2];

            list[thisC].add(new int[]{thisD, thisF});
            list[thisD].add(new int[]{thisC, thisF});
        }

        Dijkstra start = new Dijkstra(MAX_VAL, list, s);
        Dijkstra destinationA = new Dijkstra(MAX_VAL, list, a);
        Dijkstra destinationB = new Dijkstra(MAX_VAL, list, b);

        // start.sdArr[?] + destinationA.sdArr[?] + destinationB.sdArr[?]의 최소값을 찾으면 된다.

        for(int i = 1; i < n+1; i++){
            answer = Math.min(answer, start.getSdArr()[i] + destinationA.getSdArr()[i] + destinationB.getSdArr()[i]);
        }


        return answer;
    }


    public static int solution2(int n, int s, int a, int b, int[][] fares) {
        // n :: 지점 개수 / s ::시작 지점 / a :: 도착 위치 / b :: 도착 위치
        // fares :: 배열의 각 행은 [c, d, f]로 구성 :: c 지점과 d 지점 사이의 예상 택시요금이 f원

        int answer = MAX_VAL;
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] fare : fares){
            int thisC = fare[0];
            int thisD = fare[1];
            int thisF = fare[2];

            list[thisC].add(new int[]{thisD, thisF});
            list[thisD].add(new int[]{thisC, thisF});
        }

        Dijkstra_PriorityQ start = new Dijkstra_PriorityQ(MAX_VAL, list, s);
        Dijkstra_PriorityQ destinationA = new Dijkstra_PriorityQ(MAX_VAL, list, a);
        Dijkstra_PriorityQ destinationB = new Dijkstra_PriorityQ(MAX_VAL, list, b);

        // start.sdArr[?] + destinationA.sdArr[?] + destinationB.sdArr[?]의 최소값을 찾으면 된다.

        for(int i = 1; i < n+1; i++){
            answer = Math.min(answer, start.getSdArr()[i].sdValue + destinationA.getSdArr()[i].sdValue + destinationB.getSdArr()[i].sdValue);
        }


        return answer;
    }
}

