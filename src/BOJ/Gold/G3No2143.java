package BOJ.Gold;

import java.util.*;
/* =================================================
 * 2143번_두 배열의 합 - 세그먼트 트리로 해결
 *
 * 풀이 시간 : 1시간 56분
 *
 * *** 회고 ***
 * ================================================= */
public class G3No2143 {
    public static long solution(long t, int n, int m, long[] sumA, long[] sumB){
        long result = 0L;

        calDpB(m, sumB);

        int aPoint1 = 0;
        int aPoint2 = 0;
        while(aPoint1 < n){
            while(aPoint2 < n){
                long sumValA = (aPoint1 == aPoint2)
                        ? sumA[aPoint2]
                        : sumA[aPoint2] - sumA[aPoint1];

                result += findValueB(t-sumValA);

                aPoint2++;
            }
            aPoint1++;
            aPoint2 = aPoint1;
        }

        return result;
    }


    private static void calDpB(int m, long[] sumB){
        int bPoint1 = 0;
        int bPoint2 = 0;
        while(bPoint1 < m){
            while(bPoint2 < m){
                long sumValB = (bPoint1 == bPoint2)
                        ? sumB[bPoint2]
                        : sumB[bPoint2] - sumB[bPoint1];
                settingDataB(sumValB);
                bPoint2++;
            }
            bPoint1++;
            bPoint2 = bPoint1;
        }
    }



    private static final Long MAX = 2147483648L;
    private static Node bPlusRoot = new Node(1);
    private static Node bMinusRoot = new Node(1);
    private static Node bZero = new Node(31);

    private static class Node{
        int depth;
        long value;
        Node childLeft;
        Node childRight;

        public Node(int depth){
            this.depth = depth; //depth == 31이면, 리프노드다.
            this.value = 0L;
            this.childLeft = null;
            this.childRight = null;
        }
    }

    private static void settingDataB(long sumVal){
        if (sumVal == 0) bZero.value += 1;
        else if(sumVal > 0){
            setNode(bPlusRoot, sumVal, 1, MAX);
        } else {
            setNode(bMinusRoot, sumVal*(-1), 1, MAX);
        }
    }

    private static void setNode(Node root, long sumVal, long start, long end){
        root.value += 1;
        if(root.depth == 32) return;

        long mid = (start+end)/2;
        if(sumVal > mid){
            //오른쪽
            if(root.childRight == null)
                root.childRight = new Node(root.depth+1);
            setNode(root.childRight, sumVal, mid+1, end);
        } else{
            //왼쪽
            if(root.childLeft == null)
                root.childLeft = new Node(root.depth+1);
            setNode(root.childLeft, sumVal, start, mid);
        }
    }

    private static long findValueB(long sumVal){
        if (sumVal == 0) return bZero.value;
        else if(sumVal > 0){
            return findCount(bPlusRoot, sumVal, 1, MAX);
        } else {
            return findCount(bMinusRoot, sumVal*(-1), 1, MAX);
        }
    }

    private static long findCount(Node root, long sumVal, long start, long end){
        if(root.depth == 32) {
            return root.value;
        }

        long mid = (start+end)/2;
        if(sumVal > mid){
            //오른쪽
            if(root.childRight == null) return 0L;
            return findCount(root.childRight, sumVal, mid+1, end);
        } else{
            //왼쪽
            if(root.childLeft == null) return 0L;
            return findCount(root.childLeft, sumVal, start, mid);
        }
    }
}
