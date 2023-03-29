class Solution {
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int answer = 0;
    static int[][] new_board;
    static int n; 
    public int solution(int[][] board) {
        new_board = board;
        n = board.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    check(i,j);
                    answer++;
                }
            }
        }
        return n*n-answer;
    }
    
    void check(int y, int x){
        for(int i = 0; i < 8; i++){
            int new_y = y + dy[i];
            int new_x = x + dx[i];
            
            if(new_y < 0 || new_y >= n || new_x < 0 || new_x >= n){
                continue;
            }
            else if(new_board[new_y][new_x] == 2 || new_board[new_y][new_x] == 1){
                continue;
            }
            else{
                new_board[new_y][new_x] = 2; 
                answer++;
            }
        }
    }
}