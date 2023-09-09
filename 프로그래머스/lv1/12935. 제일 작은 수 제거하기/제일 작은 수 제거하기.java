import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int[] answer = {};
        int min = temp[0];

        if(arr.length == 1) {
            answer = new int[] {-1};
        } else {
            answer = new int[arr.length-1];
            int j = 0;
            for(int i = 0; i < arr.length; i++) {
                // System.out.println(arr[i]);
                if(arr[i] != min){
                    answer[j] = arr[i];
                    j++;
                } else {
                    // answer[i] = arr[i];
                    continue;
                }
            }
        }
        
        return answer;
    }
}