package array;

import java.util.Arrays;

/**
 * @Description 螺旋矩阵II.
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * @Author Phil
 * @CreateTime 2022/5/23
 **/

public class GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new GenerateMatrix().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        // 边界
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {  // for循环需要找一个不变的值
            // left to right
            for (int i = l; i <= r; i++) array[t][i] = num++;
            t++;
            // top to bottom
            for (int i = t; i <= b; i++) array[i][r] = num++;
            r--;
            // right to left
            for (int i = r; i >= l; i--) array[b][i] = num++;
            b--;
            // bottom to top
            for (int i = b; i >= t; i--) array[i][l] = num++;
            l++;
        }
        return array;
    }
}
