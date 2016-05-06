/** find all possible solutions for placing queens
 * use a ArrayList<Integer> col to record for each row, we should put queen on which col.
 * (2,1,3,0) means put queen on third col for first row.
 * dfs starts from first row, for a new row, scan each col to check whether it is valid to put a queen
**/
 
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        if (n <= 0) {
            return res;
        }
        
        ArrayList<Integer> cols = new ArrayList<Integer>();
        search(res, cols, n);
        return res;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        
        for (int j = 0; j < row; j++) {
            if (cols.get(j) == col) {
                return false;
            }
            
            if (row - j == col - cols.get(j)) {
                return false;
            }
            
            if (row - j == cols.get(j) - col) {
                return false;
            }
        }
        
        return true;
    }
    
    private void drawChessBoard(ArrayList<ArrayList<String>> res,
                                ArrayList<Integer> cols) {
        ArrayList<String> board = new ArrayList<String>();
        
        for (int i = 0; i < cols.size(); i++) {
            String currentRow = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    currentRow += "Q";
                } else {
                    currentRow += ".";    
                }
            }
            board.add(currentRow);
        }
        
        res.add(board);
    }
    
    private void search(ArrayList<ArrayList<String>> res,
                  ArrayList<Integer> cols,
                  int n) {
        if (cols.size() == n) {
            drawChessBoard(res, cols);
            return;
        }              
                      
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            
            cols.add(col);
            search(res, cols, n);
            cols.remove(cols.size() - 1);
        }       
    }
};
