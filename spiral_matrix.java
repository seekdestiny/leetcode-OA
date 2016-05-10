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
