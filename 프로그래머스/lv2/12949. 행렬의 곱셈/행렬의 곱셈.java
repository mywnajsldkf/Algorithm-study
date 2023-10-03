class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2.length];
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                int sum = 0;
                for(int y = 0; y < arr2.length; y++) {
                    sum += (arr1[i][y] * arr2[y][j]);
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}