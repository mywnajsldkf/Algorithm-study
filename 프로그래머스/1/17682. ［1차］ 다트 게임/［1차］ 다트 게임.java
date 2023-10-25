import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> score = new ArrayList<>();
                
        String strScore = "";
        for(int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);
            
            if(now == 'S') {    // single
                score.add(Integer.parseInt(strScore));
                strScore = "";
            } else if(now == 'D') { // double
                score.add((int) Math.pow(Integer.parseInt(strScore), 2));
                strScore = "";
            } else if(now == 'T') { // triple
                score.add((int) Math.pow(Integer.parseInt(strScore), 3));
                strScore = "";                
            } else if(now == '*') { // 현재와 이전에 것에 2배 곱하기
                for(int j = score.size() - 1; j >= score.size() - 2; j--) {
                    if(j < 0) break;
                    score.set(j, score.get(j) * 2);
                }
            } else if(now == '#') { // -1 하기
                score.set(score.size() - 1, score.get(score.size() - 1) * (-1));
            } else {
                strScore += String.valueOf(now);
            }
        }
        
        for(int s : score) {
            // System.out.println(s);
            answer += s;
        }
        
        return answer;
    }
}