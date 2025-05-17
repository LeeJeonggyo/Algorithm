import BOJ.Gold.G2No1766;
import BOJ.Gold.G3No2143;
import BOJ.Gold.G4No1253;
import BOJ.Gold.G5No12865;
import BOJ.Silver.S1No6236;
import BOJ.Silver.S2No9184;
import Programmers.Level2.PowerGridDivideTwo;
import Programmers.Level2.TowerOfHanoi;
import Programmers.Level3.GameOfFindPath;
import Programmers.Level3.GoldSilverCarry;
import Programmers.Level3.SharedTaxiFare;
import Programmers.Level4.MinimizeSalesDecline;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello world!");
        g3No2143Solution2();
    }

    /** ===========================================================
     * 2143번_두 배열의 합 - Map 과 구분합으로 해결
     * =========================================================== */
    public static void g3No2143Solution2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] b = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Long.parseLong(st.nextToken());
        }

        System.out.print(G3No2143.solution2(t, n, m, a, b));
    }

    /** ===========================================================
     * 2143번_두 배열의 합 - 세그먼트 트리로 해결
     * =========================================================== */
    public static void g3No2143Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] sumA = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sumA[0] = Long.parseLong(st.nextToken());
        for(int i = 1; i < n; i++){
            sumA[i] = sumA[i-1] + Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] sumB = new long[m];
        st = new StringTokenizer(br.readLine());
        sumB[0] = Long.parseLong(st.nextToken());
        for(int i = 1; i < m; i++){
            sumB[i] = sumB[i-1] + Long.parseLong(st.nextToken());
        }

        System.out.print(G3No2143.solution(t, n, m, sumA, sumB));
    }


    /** ===========================================================
     * 1766번_문제집 - 우선순위 큐로 해결
     * =========================================================== */
    public static void g2No1766Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] data = new int[m][2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(G2No1766.solution(n, m, data));
    }


    /** ===========================================================
     * 9184번_신나는 함수 실행 - DP로 해결
     * =========================================================== */
    private static void s2No9184Solution() throws IOException{
        S2No9184.solution();
    }


    /** ===========================================================
     * 12865번_평범한 배낭 - DP로 해결
     * =========================================================== */
    private static void g5No12865Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] obj = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            obj[i][0] = Integer.parseInt(st.nextToken()); // W : 무게
            obj[i][1] = Integer.parseInt(st.nextToken()); // V : 가치
        }
        System.out.print(G5No12865.solution(n, k, obj));
    }

    /** ===========================================================
     * 6236번_용돈관리 - 이분 탐색으로 해결
     * =========================================================== */
    private static void s1No6236Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] data = new long[n];
        for(int i = 0; i < n; i++){
            data[i] = Long.parseLong(br.readLine());
        }

        System.out.print(S1No6236.solution(n, m, data));
    }

    /** ===========================================================
     * 1253번_좋다 - 투포인터로 해결
     * =========================================================== */
    private static void g4No1253Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] data = new long[n];
        for(int i = 0; i < n; i++){
            data[i] = Long.parseLong(st.nextToken());
        }

        System.out.print(G4No1253.solution(n, data));
    }



//    /** ===========================================================
//     * 매출 하락 최소화
//     * =========================================================== */
//    private static void minimizeSalesDeclineSolution() throws IOException{
//        /* ===========================================================
//         * TEST CASE
//         * 14 17 15 18 19 14 13 16 28 17
//         * 10 8 1 9 9 7 5 4 1 5 5 10 10 6 1 3 10 2
//         * ================================================== */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] sales = new int[st.countTokens()];
//        for(int i = 0; i < sales.length; i++){
//            sales[i] = Integer.parseInt(st.nextToken());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int[][] links = new int[st.countTokens()/2][2];
//        for(int i = 0; i < links.length; i++){
//            links[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
//        }
//
//        System.out.print(MinimizeSalesDecline.solution(sales, links));
//
//    }

    /** ===========================================================
     * 길 찾기 게임 - 이진탐색(이분탐색)으로 해결
     * =========================================================== */
    private static void gameOfFindPathSolution() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 5 3 11 5 13 3 3 5 6 1 1 3 8 6 7 2 2 2
         * ================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] nodeinfo = new int[st.countTokens()/2][2];
        for(int i = 0; i < nodeinfo.length; i++){
            nodeinfo[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }


        int[][] result = GameOfFindPath.solution(nodeinfo);

        for(int i = 0; i < nodeinfo.length; i++){
            System.out.print(result[0][i]+" ");
        }
        System.out.println();
        for(int i = 0; i < nodeinfo.length; i++){
            System.out.print(result[1][i]+" ");
        }

    }


    /** ===========================================================
     * 금과 은 운반하기 - 이진탐색(이분탐색)으로 해결
     * =========================================================== */
    private static void goldSilverCarrySolution() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 10
         * 10
         * 100
         * 100
         * 7
         * 10
         *
         * 90
         * 500
         * 70 70 0
         * 0 0 500
         * 100 100 2
         * 4 8 1
         * =========================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int i = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] g = new int[st.countTokens()];
        while(st.hasMoreTokens()) g[i++] = Integer.parseInt(st.nextToken());

        i = 0;
        st = new StringTokenizer(br.readLine());
        int[] s = new int[st.countTokens()];
        while(st.hasMoreTokens()) s[i++] = Integer.parseInt(st.nextToken());

        i = 0;
        st = new StringTokenizer(br.readLine());
        int[] w = new int[st.countTokens()];
        while(st.hasMoreTokens()) w[i++] = Integer.parseInt(st.nextToken());

        i = 0;
        st = new StringTokenizer(br.readLine());
        int[] t = new int[st.countTokens()];
        while(st.hasMoreTokens()) t[i++] = Integer.parseInt(st.nextToken());

        long result = GoldSilverCarry.solution(a, b, g, s, w, t);
        System.out.print(result);
    }


    /** ===========================================================
     * 전력망을 둘로 나누기 - 완전탐색(브루트포스) 로 구현
     * =========================================================== */
    private static void powerGridDivideTwoSolution() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 9
         * 1 3 2 3 3 4 4 5 4 6 4 7 7 8 7 9
         * =========================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] wires = new int[st.countTokens()/2][2];
        int i = 0;
        while(st.hasMoreTokens()){
            wires[i++] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int result = PowerGridDivideTwo.solution(n, wires);
        System.out.print(result);
    }


    /** ===========================================================
     * 하노이의 탑 - 재귀로 구현
     * =========================================================== */
    private static void towerOfHanoiSolution() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 2
         * =========================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] result = TowerOfHanoi.solution(n);
        for(int[] data : result){
            System.out.printf("[%d, %d]\n",data[0],data[1]);
        }
    }

    /** ===========================================================
     * 합승 택시 요금 - Dijkstra::우선순위 큐를 사용해서 구현
     * =========================================================== */
    private static void sharedTaxiFareSolution2() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 6 4 6 2
         * 4 1 10
         * 3 5 24
         * 5 6 2
         * 3 1 41
         * 5 1 24
         * 4 6 50
         * 2 4 66
         * 2 3 22
         * 1 6 25
         * =========================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] fares = new int[9][3];
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            fares[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        System.out.print(SharedTaxiFare.solution2(n,s,a,b,fares));
    }

    /** ===========================================================
     * 합승 택시 요금 - Dijkstra
     * =========================================================== */
    private static void sharedTaxiFareSolution() throws IOException{
        /* ===========================================================
         * TEST CASE
         * 6 4 6 2
         * 4 1 10
         * 3 5 24
         * 5 6 2
         * 3 1 41
         * 5 1 24
         * 4 6 50
         * 2 4 66
         * 2 3 22
         * 1 6 25
         * =========================================================== */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] fares = new int[9][3];
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            fares[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        System.out.print(SharedTaxiFare.solution(n,s,a,b,fares));
    }
}