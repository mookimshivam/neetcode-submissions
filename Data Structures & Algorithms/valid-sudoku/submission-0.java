class Solution {
    private  boolean isRowValid(char[] row){
        HashSet<Integer> set = new HashSet<>();
        for(char c: row){
            if('.' == c)
                continue;
            int curr = c - '0';
            if(set.contains(curr))
                return false;
            set.add(curr);
        }
        return true;
    }
    private  boolean isColumnValid(char[][] board, int col){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            char c = board[i][col];
            if('.' == c)
                continue;
            int curr = c - '0';
            if(set.contains(curr))
                return false;
            set.add(curr);
        }
        return true;
    }
    private  boolean isSquareValid(char[][] board, int row, int col){
        HashSet<Integer> set = new HashSet<>();
        int i = row;
        while(i < row+3){
            int j = col;
            while(j < col+3){
                char c = board[i][j];
                if('.' == c){
                    j++;
                    continue;
                }
                int curr = c - '0';
                if(set.contains(curr))
                    return false;
                set.add(curr);
                j++;
            }
            i++;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!isRowValid(board[i]))
                return false;
            if(!isColumnValid(board, i))
                return false;
        }
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                if(!isSquareValid(board, i, j))
                    return false;
            }
        }
        return true;
    }
}
