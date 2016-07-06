public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    
    if (array.length % 2 == 0) {
      return reorder(array, 0, array.length - 1);
    } else {
      return reorder(array, 0, array.length - 2);
    }
  }
  
  private int[] reorder(int[] array, int left, int right) {
    int length = right - left + 1;
    if (length <= 3) {
      return array;
    }
    
    int lmid = left + length / 4;
    int mid = left + length / 2;
    int rmid = left + length * 3 / 4;
    
    reverse(array, lmid, mid - 1);
    reverse(array, mid, rmid - 1);
    reverse(array, lmid, rmid - 1);
    reorder(array, left, mid - 1);
    reorder(array, mid, right);
    
    return array;
  }
  
  private void reverse(int[] array, int left, int right) {
    while (left < right) {
     int temp = array[left];
     array[left] = array[right];
     array[right] = temp;
     left++;
     right--;
    }
  }
}
