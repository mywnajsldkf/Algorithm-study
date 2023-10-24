class Solution {
    // n: 진법, t: 미리 구할 숫자의 갯수, m: 게임 참가 인원, p: 튜브 순서    
    public String solution(int n, int t, int m, int p) {    
        String answer = "";
        StringBuilder sb;
        String gameAnswer = "0";

        for(int i = 1; i <= t*m; i++) {
            int now = i;
            sb = new StringBuilder();
            while(now != 0) {
                int mock = now % n;
                if(mock >= 10) {
                    sb.append((char) (mock + 55));
                } else sb.append(now % n);
                    
                now /= n;
            }
            gameAnswer += sb.reverse();
        }
                
        int order = 1;
        for(int i = 0; i < gameAnswer.length(); i++) {
            if(answer.length() == t) break;
            if(order > m) {
                order = 1;
            }
            if(order == p) {
                answer += gameAnswer.charAt(i);
            }
            order++;
        }
            
        return answer;
    }
}

// 01, 10, 11, 100 -> t개를 구하고
// 0111