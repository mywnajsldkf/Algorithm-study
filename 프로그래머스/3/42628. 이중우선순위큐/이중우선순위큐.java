import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] str = op.split(" ");
            String judge = str[0];
            int value = Integer.parseInt(str[1]);
            if(queue.size() < 1 && judge.equals("D")) {
                continue;
            }
            
            if(judge.equals("I")) {
                queue.add(value);
                maxPq.add(value);
            } else if(judge.equals("D") && value == 1) {
                int max = maxPq.poll();
                queue.remove(max);
            } else if(judge.equals("D") && value == -1) {
                int min = queue.poll();
                maxPq.remove(min);
            }
        }
        
        if(queue.size() > 0) {
            answer[0] = maxPq.poll();
            answer[1] = queue.poll();
        }
        
        return answer;
    }
}