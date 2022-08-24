package day3;

/**
 * @Description 找到最近的有相同 X 或 Y 坐标的点.
 * 给你两个整数x 和y，表示你在一个笛卡尔坐标系下的(x, y)处。同时，在同一个坐标系下给你一个数组points，
 * 其中points[i] = [ai, bi]表示在(ai, bi)处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是有效的。
 * <p>
 * 请返回距离你当前位置曼哈顿距离最近的有效点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标最小的一个。如果没有有效点，请返回-1。
 * <p>
 * 两个点 (x1, y1)和 (x2, y2)之间的曼哈顿距离为abs(x1 - x2) + abs(y1 - y2)。
 *
 *
 * <p>
 * 示例 1：
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 *
 * <p>
 * 示例 2：
 * 输入：x = 3, y = 4, points = [[3,4]]
 * 输出：0
 * 提示：答案可以与你当前所在位置坐标相同。
 *
 * <p>
 * 示例 3：
 * 输入：x = 3, y = 4, points = [[2,3]]
 * 输出：-1
 * 解释：没有 有效点。
 * @Author Phil
 * @CreateTime 2022/5/16
 **/

public class Day3_2 {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(nearestValidPoint(3, 4, points));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            // 1、判断当前点是否为有效点
            // x与[ai,bi]中ai比较，y与bi比较
            if (points[i][0] == x || points[i][1] == y) {
                // 2、计算曼哈顿距离
                int temp = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (temp < minDistance) {
                    minDistance = temp;
                    // 3、记录最小值的下标
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
