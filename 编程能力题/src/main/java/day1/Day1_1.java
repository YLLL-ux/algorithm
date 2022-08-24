package day1;

/**
 * @Description 在区间范围内统计奇数数目
 * <p>
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * 示例 1：
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * <p>
 * 示例 2：
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * @Author Phil
 * @CreateTime 2022/5/14
 **/

public class Day1_1 {
    public static void main(String[] args) {
        int low = 3;
        int high = 7;
        int i = countOdds(high) - countOdds(low - 1);
        System.out.println(i);
    }

    /**
     * 方法一：暴力枚举，超时
     */
    public static int countOdds(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                sum += 1;
            }
        }
        return sum;
    }

    /**
     * 方法二：case x>>1 == x/2 then (x+1)右移一位 = ((x+1)/2) 取整
     * <p>
     * 说明：x为非负数，或 x为负数且还是偶数的情况适用。
     * 使用场景：在二分法中可以用到。在计算 [0,x]区间中奇数数字的个数。
     */
    public static int countOdds(int x) {
        return (x + 1) >> 1;
    }
}
