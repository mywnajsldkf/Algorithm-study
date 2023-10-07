class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1은 1, 2, 3, 4, 5, 6, 7, 8, 9, 10의 약수
        // 2는 2, 4, 6, 8, 10의 약수
        // 3은 3, 6, 9의 약수
        // 4는 4, 8의 약수
        
        int[] yaksoo = new int[number+1];
        
        for(int y = 1; y <= number; y++) {
            for(int now = y; now <= number; now += y) {
                yaksoo[now] += 1;
            }
        }
        
        for(int y : yaksoo) {
            if(y > limit) {
                answer += power;
            } else {
                answer += y;
            }
        }
        
        return answer;
    }
}