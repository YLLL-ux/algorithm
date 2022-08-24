package array;

import java.util.Arrays;

/**
 * @Description 有序数组的平方。
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * @Author Phil
 * @CreateTime 2022/5/21
 **/

public class SquareOfOrderedArray {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new SquareOfOrderedArray().sortedSquares1(nums)));
    }

    /**
     * 暴力排序
     */
    private int[] sortedSquares(int[] nums) {
        int[] newArray = new int[nums.length];
        // 平方
        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i] * nums[i];
            // 使用Math工具类
            int temp = (int) Math.pow(nums[i], 2);
            newArray[i] = temp;
        }
        Arrays.sort(newArray);
        return newArray;
    }

    /**
     * 双指针法（二刷时学习）
     */
    private int[] sortedSquares1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 创建新的数组
        int[] result = new int[nums.length];
        int index = result.length - 1;
        // 遍历原数组
        while (left <= right) {
            // 如果nums[left]*nums[left] > nums[right]*nums[right] ===> result[index--] = nums[left]*nums[left]
            // 如果nums[left]*nums[left] <= nums[right]*nums[right] ===> result[index--] = nums[right]*nums[right]
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
