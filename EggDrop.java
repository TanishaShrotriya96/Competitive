// TODO: 
// Read please: http://datagenetics.com/blog/july22012/index.html

// https://www.youtube.com/watch?v=o_AJ3VWQMzA

// https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/EggSolver.java

// DP Solution

import java.util.Arrays;
// n = floors and k = eggs
public class EggDrop {
    public static void main(String[] args) {
        System.out.println(new EggDrop().solveUsingDp(8, 4));
    }

    public int solveUsingDp(int n, int k) {
    	// note importance of 0th index.
        final int results[][] = new int[n + 1][k + 1];

        // If there is only 1 egg, then worst case = no. of floors
        for (int i = 0; i < n + 1; i++) {
            results[i][1] = i;
        }

        //  If there is only 1 floor, no. of eggs doesn't matter.

        for (int i = 0; i < k + 1; i++) {
            results[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
                results[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x < i; x++) {
                    final int brokenEggResult = results[x - 1][j - 1];
                    final int EggSurvivedResult = results[i - x][j];
                    int temp = Math.max(brokenEggResult, EggSurvivedResult) + 1;
                    if (temp < results[i][j]) {
                        results[i][j] = temp;
                    }
                }
            }
        }
        for (final int[] a : results) {
            System.out.println(Arrays.toString(a));
        }
        return results[n][k];
    }
}

/*
[0, 0, 0, 0, 0] 
[1, 1, 1, 1, 1] --> Only 1 floor
[0, 2, 2, 2, 2]
[0, 3, 2, 2, 2]
[0, 4, 3, 3, 3]
[0, 5, 3, 3, 3]
[0, 6, 3, 3, 3]
[0, 7, 4, 3, 3]
[0, 8, 4, 4, 4]
    | 
   \ /
  Only 1 egg.
*/

