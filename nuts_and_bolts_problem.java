/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;
        
        quickSort(nuts, bolts, 0, nuts.length - 1, compare);
    }
    
    private void quickSort(String[] nuts, String[] bolts, int start, int end, NBComparator compare) {
        if (start >= end) return;
        
        int pivot = partition(nuts, bolts[start], start, end, compare);
        partition(bolts, nuts[pivot], start, end, compare);
        
        quickSort(nuts, bolts, start, pivot - 1, compare);
        quickSort(nuts, bolts, pivot + 1, end, compare);
    }
    
    private int partition(String[] str, String target, int start, int end, NBComparator compare) {
        int l = start;
        int r = end;
        int i = start;
        
        while (i <= r) {
            if (compare.cmp(str[i], target) == -1 || 
                compare.cmp(target, str[i]) == 1) {
                swap(str, i, l);
                i++;
                l++;
            } else if (compare.cmp(str[i], target) == 1 || 
                       compare.cmp(target, str[i]) == -1) {
                swap(str, i, r);
                r--;
            } else {
                i++;
            }   
        }
        
        return l;
    }
    
    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
};
