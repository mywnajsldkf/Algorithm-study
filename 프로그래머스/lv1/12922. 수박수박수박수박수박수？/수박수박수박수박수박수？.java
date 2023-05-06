class Solution {
    public String solution(int n) {
        String answer = "";
        
        // 수박수
        if(n % 2 == 1){
            for (int i = 0; i < n / 2; i++){
                answer += "수박";
            }
            answer += "수";
        }
        
        // 수박수박
        if(n % 2 == 0){
            for (int i = 0; i < n / 2; i++){
                answer += "수박";
            }
        }
        
        return answer;
    }
}