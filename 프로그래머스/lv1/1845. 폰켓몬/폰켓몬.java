import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> mons = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (mons.contains(nums[i])) {
                continue;
            }
            else {
                mons.add(nums[i]);
            }
        }
        
        if (nums.length/2 > mons.size()) {
            answer = mons.size();
        }
        else {
            answer = nums.length/2;
        }

        return answer;
    }
}