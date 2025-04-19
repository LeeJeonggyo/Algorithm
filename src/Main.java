import Programmers.Level2.PowerGridDivideTwo;
import Programmers.Level2.TowerOfHanoi;
import Programmers.Level3.GameOfFindPath;
import Programmers.Level3.GoldSilverCarry;
import Programmers.Level3.SharedTaxiFare;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello world!");
        gameOfFindPathSolution();
    }

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