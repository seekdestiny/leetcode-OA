/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
 
class SegmentTreeNode {
    public int start;
    public int end;
    public long sum;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}

public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.length == 0) {
            return result;
        }
        
        SegmentTreeNode root = build(0, A.length - 1, A);
        
        for (Interval i : queries) {
            long temp = query(root, i.start, i.end);
            result.add(new Long(temp));
        }
        
        return result;
    }
    
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
            return root;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        int mid = (start + end) / 2;
        root.left = build(start, mid, A);
        root.right = build(mid + 1, end, A);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public long query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        
        long leftSum = 0;
        long rightSum = 0;
        
        if (start <= mid) {
            if (end <= mid) {
                leftSum = query(root.left, start, end);
            } else {
                leftSum = query(root.left, start, mid);
            }
        }
        
        if (mid + 1 <= end) {
            if (start >= mid + 1) {
                rightSum = query(root.right, start, end);
            } else {
                rightSum = query(root.right, mid + 1, end);
            }
        }
        
        return leftSum + rightSum;
    }
}
