import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        int[] result;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        
        if(answer.size() == 0){
            result = new int[]{-1};
        }
        else{
            Collections.sort(answer);
            result = new int[answer.size()];
            for(int i = 0; i < answer.size(); i++){
                result[i] = answer.get(i);
            }
        }
        return result;
    }
}