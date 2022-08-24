package array;

/**
 * @Description 长度最小的子数组.
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * @Author Phil
 * @CreateTime 2022/5/23
 **/

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, nums));
    }

    /**
     * 暴力解
     */
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE; // 最终结果
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    // 更新 result
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
