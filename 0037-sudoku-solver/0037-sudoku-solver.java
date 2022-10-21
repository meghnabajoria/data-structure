class Solution {
    public void solveSudoku(char[][] board) {
         if(board == null || board.length == 0)
            return;
        recursion(board);
    }
    
    private boolean recursion(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == '.') {
                    
                    for(char c = '1'; c<='9'; c++) {
                        if(isValid(i,j,c,board)) {
                            board[i][j] = c;
                            
                            if(recursion(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
      public static boolean isValid(int row, int col, char c,char[][] board) {
        for (int i = 0; i < 9; i++) {
          if (board[i][col] == c)
            return false;

          if (board[row][i] == c)
            return false;

          if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
            return false;
        }
        return true;
      }
    
//     private boolean isValid(int row, int col, char x, char[][] board) {
        
//         for(int dcol = 0;dcol<board.length;dcol++) {
//             if(board[row][dcol] == x)
//                 return false;
//         }
        
//         for(int drow = 0; drow < board.length; drow++) {
//             if(board[drow][col] == x)
//                 return false;
//         }
        
//         int[] r = new int[] {-1,-1,1,1};
//         int[] c = new int[] {-1,1,1,-1};
        
//         for(int it = 0; it < 4; it++) {
//             int nrow = row + r[it];
//             int ncol = col + c[it];
//             if(nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board.length && board[nrow][ncol] == x)
//                 return false;    
//         }
//         return true;
//     }
}