import java.util.*;

class Solution {
    // static Set<Integer> numbers;
    // static int[] selectNums;
    static int answer;
    public int solution(int[] nums) {
        // selectNums = nums;
        // numbers = new HashSet<>();
        answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(num >= 2) {
                        if(isSosoo(num)) {
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    static boolean isSosoo(int number) {
        boolean result = true;
        if(number == 2) {
            return result;
        }
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}