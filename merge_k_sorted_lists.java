/**
 * solution1: use min heap
**/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    class Element {
        int row;
        int col;
        int value;
        
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
     
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element e1, Element e2) {
            return e1.value - e2.value;
        }
    };
     
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return res;
        }

        Queue<Element> q = new PriorityQueue<Element>(arrays.length, ElementComparator);
        
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                q.add(new Element(i, 0, arrays[i][0]));
            }
        }
        
        while (!q.isEmpty()) {
            Element temp = q.poll();
            res.add(temp.value);
            int row = temp.row;
            int col = temp.col;
            if (col < arrays[row].length - 1) {
                col++;
                q.add(new Element(row, col, arrays[row][col]));
            }
        }
        
        return res;
    }
}
