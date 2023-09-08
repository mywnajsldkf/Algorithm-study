class Solution {
    public String solution(String s) {
        String[] arr = s.split(" "); 
        String answer = "";
        for(int i = 0; i < arr.length; i++) {
            String now = arr[i];
            
            if(now.length() == 0) {
                answer += " ";
            } else {
                // 0번째 문자는 대문자
                answer += now.substring(0,1).toUpperCase();
                // 1번째 문자부터 마지막까지 소문자로
                answer += now.substring(1,now.length()).toLowerCase();
                answer += " ";   
            }
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length()-1);
    }
}