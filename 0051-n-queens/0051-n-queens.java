class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        recursion(board, 0, ans);
        return ans;
    }
    
    private void recursion(char[][] board, int col, List<List<String>> ans) {
        
        if(col >= board.length) {
            ans.add(makeIntoList(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++) {
            if(isSafe(row,col,board)) {
                board[row][col] = 'Q';
                recursion(board, col+1, ans);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(int row, int col, char[][] board) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
        
        
    }
    
    private List<String> makeIntoList(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}