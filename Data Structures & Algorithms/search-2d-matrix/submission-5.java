class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int lRow = 0, rRow = rows - 1;
        int lCol = 0, rCol = cols - 1;
        int theRow = -1;

        // deciding the row which can possibly have the target value
        while(lRow <= rRow){
            int mRow = (lRow + rRow)/2;
            // if target is less than 1st-element of the row
            // move right to previous row
            if(target < matrix[mRow][0])
                rRow = mRow - 1;
            // if target is more than last-element of the row
            // move left to next row
            else if(target > matrix[mRow][cols - 1])
                lRow = mRow + 1;
            // target can exist in this row only
            else{
                theRow = mRow;
                break;
            }
        }

        // immediately return false if theRow = -1
        // it means there are no range that could possibly have target
        if(theRow == -1)
            return false;

        // look for the target in identified row
        while(lCol <= rCol && theRow >= 0){
            int mCol = (lCol + rCol)/2;
            if(target == matrix[theRow][mCol])
                return true;
            else if(target > matrix[theRow][mCol])
                lCol = mCol + 1;
            else{
                rCol = mCol - 1;
            }
        }
        return false;
    }
}
