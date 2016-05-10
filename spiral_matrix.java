/** hard implementation
* easy algorithm
**/

class Direction {
    public static int DOWN = 0;
    public static int LEFT = 1;
    public static int UP = 2;
    public static int RIGHT =3;
    
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, -1, 0, 1};
    
    public static int turnRight(int direction) {
        if (direction == DOWN) {
            return LEFT;
        } else if (direction == LEFT) {
            return UP;
        } else if (direction == UP) {
            return RIGHT;
        } else if (direction == RIGHT) {
            return DOWN;
        } else {
            return -1;
        }
    }
    
    public static int[] nextMove(int[] cursor, int direction) {
        int[] next = new int[2];
        next[0] = cursor[0] + dx[direction];
        next[1] = cursor[1] + dy[direction];
        return next;
    }
}

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null | matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] cursor = new int[]{0, 0};
        int direction = Direction.RIGHT;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[cursor[0]][cursor[1]]);
            visited[cursor[0]][cursor[1]] = true;
            
            int[] nextCursor = Direction.nextMove(cursor, direction);
            if ((nextCursor[0] < 0 || nextCursor[0] >= m) ||
                (nextCursor[1] < 0 || nextCursor[1] >= n) ||
                visited[nextCursor[0]][nextCursor[1]]) {
                direction = Direction.turnRight(direction);
                nextCursor = Direction.nextMove(cursor, direction);
            }
            
            cursor = nextCursor;
        }
        
        return res;
    }
}

/**
 * 与Rotate Image那题类似，一层一层处理。但这题有两个注意点：
 * 1. m和n可以不同，所以对于第i层来说，最后一行为lastRow = m-1-i，而最后一列为lastCol = n-1-i。所以层数由min(m,n)决定。
 * 2. 当min(m,n)为奇数时，最后一层为一行或一列，需要特殊处理。
**/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int level = (Math.min(m, n) + 1) / 2;
        for (int i = 0; i < level; i++) {
            int lastRow = m - 1 - i;
            int lastCol = n - 1 - i;
            
            if (lastRow == i) {
                for (int j = i; j <= lastCol; j++) res.add(matrix[i][j]);
            } else if (lastCol == i) {
                for (int j = i; j <= lastRow; j++) res.add(matrix[j][i]);
            } else {
                for (int j = i; j < lastCol; j++) res.add(matrix[i][j]);
                for (int j = i; j < lastRow; j++) res.add(matrix[j][lastCol]);
                for (int j = lastCol; j > i; j--) res.add(matrix[lastRow][j]);
                for (int j = lastRow; j > i; j--) res.add(matrix[j][i]);
            }
        }
        
        return res;
    }
}
