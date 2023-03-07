import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] sudoku = new int[9][9];
    static StringTokenizer str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        playSudoku(0,0);
    }

    public static void playSudoku(Integer row, Integer col) {
        if (col == 9) {
            playSudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    sudoku[row][col] = i ;
                    playSudoku(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        playSudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value) {
        // 행(가로) 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        // 열(세로) 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        // 3 * 3 검사
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}