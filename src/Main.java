import Programmers.Level3.SharedTaxiFare;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello world!");
        sharedTaxiFareSolution2();
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