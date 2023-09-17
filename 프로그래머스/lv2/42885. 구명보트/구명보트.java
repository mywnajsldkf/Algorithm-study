import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        boolean[] visited = new boolean[people.length];
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            int total = 0;
            int l = people[left];
            int r = people[right];
            if(l + r > limit) {
                right--;
                answer++;
            }
            else if(l + r <= limit) {
                left++;
                right--;
                answer += 1;
            }
        }
        
        return answer;
    }
}