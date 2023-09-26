import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> temp = new ArrayList<>();
        
        int idx = 0;
        for(int s : score) {
            if(temp.size() < k) {
                temp.add(s);
                Collections.sort(temp);
                answer[idx] = temp.get(0);
            }
            else if(temp.size() == k) {
                int min = temp.get(0);
                if(min < s) {
                    temp.remove(0);
                    temp.add(s);
                    Collections.sort(temp);
                }
                answer[idx] = temp.get(0);
            }
            idx++;
        }

        return answer;
    }
}