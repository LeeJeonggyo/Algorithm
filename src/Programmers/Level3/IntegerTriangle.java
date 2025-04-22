package Programmers.Level3;

/* =================================================
 * 정수 삼각형 - DP 로 해결
 * ================================================= */
public class IntegerTriangle {
    public static int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1; i < triangle.length; i++){
            int[] bfEle = triangle[i-1];
            int[] thisEle = triangle[i];
            for(int j = 0; j < thisEle.length; j++){
                if(j == 0) {
                    thisEle[j] += bfEle[j];
                } else if(j == thisEle.length-1){
                    thisEle[j] += bfEle[j-1];
                } else {
                    thisEle[j] += Math.max(bfEle[j-1], bfEle[j]);
                }
                answer = Math.max(answer, thisEle[j]);
            }
        }

        return answer;
    }
}
