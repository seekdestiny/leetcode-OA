//bucket sort

import java.util.*;

public class HelloWorld{
     public void sortKColors(int[] colors, int k) {
        if (colors == null) {
            return;
        }
        
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else {
                    colors[num - 1]--;
                    colors[i] = 0;
                }
            }
        }
        
        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            
            if (cnt == 0) {
                continue;
            }
            
            while (cnt > 0) {
                colors[index--] = i + 1;   
                cnt--;
            }
        }
     }

     public static void main(String []args){
        HelloWorld solution = new HelloWorld();
        int[] colors = new int[]{2, 1, 1, 1, 1, 1, 3, 3};
        solution.sortKColors(colors, 3);
        System.out.println(Arrays.toString(colors));
     }
}
