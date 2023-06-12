import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1];});
        
        // 2차원 배열 정렬
        // for(int i = 0; i < targets.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.print(targets[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int last = -1;
        for (int[] target : targets) {
            // 첫번째 수
            if(last == -1) {
                answer++;
                last = target[1] - 1;
                continue;
            }
            
            if(last >= target[0] && last <= target[1]) continue;
            
            answer++;
            last = target[1] -1;
        }
    
        return answer;
    }
}