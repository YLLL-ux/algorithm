package day3;

import java.util.Arrays;

/**
 * @Description 三角形的最大周长。
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * @Author Phil
 * @CreateTime 2022/5/16
 **/

public class Day3_1 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(largestPerimeter(nums));
    }

    /*
        贪心（做出再当前看来最好的选择）+ 倒序枚举
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
