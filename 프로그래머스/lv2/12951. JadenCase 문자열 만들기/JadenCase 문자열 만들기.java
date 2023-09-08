class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        
        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            // 공백이면 이 다음에 대문자로 바꿔줘야하니까
            flag = ss.equals(" ") ? true : false;
        }
        return answer;
    }
}