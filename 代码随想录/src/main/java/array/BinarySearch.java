package array;

/**
 * @Description 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * @Author Phil
 * @CreateTime 2022/5/20
 **/

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(new BinarySearch().search(nums, target));
    }

    /**
     * 暴力解
     */
    private int search1(int[] nums, int target) {
        int subscript = -1;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number == target) {
                subscript = i;
            }
        }
        return subscript;
    }

    /**
     * 二分法。
     * 中间值如何获取？？
     */
    private int search(int[] nums, int target) {
        // 左右两侧下标
        int left = 0, right = nums.length - 1;
        // target小于最小值或大于最大值，均需要返回-1
        if (target < nums[0] || target > nums[right]) return -1;

        while (left <= right) {
            // 中间值
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        // 未找到
        return -1;
    }
}
