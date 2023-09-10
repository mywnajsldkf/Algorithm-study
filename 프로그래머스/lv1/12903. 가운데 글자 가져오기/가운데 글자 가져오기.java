class Solution {
    public String solution(String s) {
        String answer = "";
        int size = s.length();
        int middle = size / 2;
        if(size % 2 == 0) {
            answer = String.valueOf(s.charAt(middle-1)) + String.valueOf(s.charAt(middle));
        } else {
            answer = String.valueOf(s.charAt(middle));
        }
        return answer;
    }
}