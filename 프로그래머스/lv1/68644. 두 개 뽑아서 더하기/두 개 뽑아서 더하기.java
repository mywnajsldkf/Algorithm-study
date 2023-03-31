import java.util.*;

class Solution {
    public Set<Integer> solution(int[] numbers) {
        Set<Integer> result = new TreeSet<>();
        int[] answer = {};
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                // System.out.print(numbers[i]*numbers[j] + " ");
                result.add(numbers[i] + numbers[j]);
            }
        }
        // Collections.sort(result);
        return result;
    }
}