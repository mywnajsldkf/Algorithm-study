class Solution {
    public int solution(int n, int[] stations, int w) {
        int now = 1;
        int stationIdx = 0; // 기지국 idx
        int answer = 0;
        
        // 현재 위치가 범위 이내인 경우 
        while(now <= n) {
            // 현재 위치가 모든 기지국 범위를 넘어선 경우, 기지국의 범위보다 작은 경우
            if(stationIdx >= stations.length ||
               now < stations[stationIdx] - w) {
                answer++;
                now = now + 2 * w + 1;
            }
            // 현재 위치가 모든 기지국 범위보다 작고 특정 기지국 범위 내에 있는 경우
            else {
                now = stations[stationIdx] + w + 1;
                stationIdx++;
            }
        }
        
        return answer;
    }
}