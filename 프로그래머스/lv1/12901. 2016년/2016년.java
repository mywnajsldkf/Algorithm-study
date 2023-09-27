class Solution {
    public String solution(int a, int b) {
        // 요일들     
        int days = b-1;
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        for(int i = 0; i < a-1; i++) {
            days += date[i];
        }
        System.out.println("days: " + days);
        String answer = day[days % 7];
        return answer;
    }
}