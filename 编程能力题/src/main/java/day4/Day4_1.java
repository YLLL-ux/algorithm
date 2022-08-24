package day4;

/**
 * @Description 数组元素积的符号.
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * 示例 3：
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * @Author Phil
 * @CreateTime 2022/5/17
 **/

public class Day4_1 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 2, -3};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int sign = 1;
        for (int temp : nums) {
            if (temp == 0) { // 数组中有一个0，则乘积就为零
                return 0;
            } else if (temp < 0) { // 有一个负数就 标志sign 就乘-1
                sign *= -1;
            }
        }
        return sign > 0 ? 1 : -1;
    }
}
