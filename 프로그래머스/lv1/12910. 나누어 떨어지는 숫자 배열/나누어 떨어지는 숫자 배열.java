import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> arrList = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                arrList.add(arr[i]);
            }
        }
        
        if(arrList.size() == 0) {
            answer = new int[] {-1};
            return answer;
        }
        Collections.sort(arrList);
        
        answer = new int[arrList.size()];
        
        for(int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}