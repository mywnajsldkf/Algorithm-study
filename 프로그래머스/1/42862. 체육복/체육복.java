class Solution {
    // n: 학생 수, lost: 도난당한 학생들, reverse: 여벌 체욕복 가져온
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n+2];
        
        for(int l : lost) {
            students[l] = -1;
        }
        
        for(int r : reserve) {
            if(students[r] == -1) students[r] = 0;
            else students[r] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] == -1) {
                if(students[i-1] == 1) {
                    students[i-1] = 0;
                    students[i] = 0;
                } else if(students[i+1] == 1) {
                    students[i+1] = 0;
                    students[i] = 0;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] != -1) answer++;
        }
        
        return answer;
    }
}