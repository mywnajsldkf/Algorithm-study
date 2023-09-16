class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] arr = new int[n][n];

        int idx = 0;
        for(int a1 : arr1) {
            String na = Integer.toBinaryString(a1);
            int size = na.length();
            if(size < n) {
                int i;
                for(i = 0; i < n-size; i++) {
                    arr[idx][i] = 0;
                }
                for(int j = i; j < n; j++) {
                    arr[idx][j] = Integer.parseInt(String.valueOf(na.charAt(j-n+size)));
                }
            }
            else {
                for(int i = 0; i < n; i++) {
                    arr[idx][i] = Integer.parseInt(String.valueOf(na.charAt(i)));
                }
            }
            idx++;
        }
        
        idx = 0;
        for(int a1 : arr2) {
            String na = Integer.toBinaryString(a1);
            int size = na.length();
            
            if(size < n) {
                int i;
                for(i = 0; i < n-size; i++) {
                    if(arr[idx][i] == 1) {
                        continue;
                    }
                    arr[idx][i] = 0;
                }
                for(int j = i; j < n; j++) {
                    if(arr[idx][j] == 1) {
                        continue;
                    }
                    arr[idx][j] = Integer.parseInt(String.valueOf(na.charAt(j-n+size)));
                }
            }
            else {
                for(int i = 0; i < n; i++) {
                    if(arr[idx][i] == 1) {
                        continue;
                    }
                    arr[idx][i] = Integer.parseInt(String.valueOf(na.charAt(i)));
                }
            }
            idx++;
        }
        
        for(int i = 0; i < n; i++) {
            String str = "";
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    str += "#";
                } else {
                    str += " ";
                }
            }
            answer[i] = str;
        }
        
        return answer;
    }
}