package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 两数之和。
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15,2], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @Author Phil
 * @CreateTime 2022/6/15
 **/

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new TwoSum().twoSum_hashMap(nums, target);
        System.out.println(Arrays.toString(result));
    }

    // 暴力解法，两层for
    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] recordArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    recordArr[0] = i;
                    recordArr[1] = j;
                }
            }
        }
        return recordArr;
    }

    // 用map做哈希表, c=a+b => b=c-a; a=c-b
    private int[] twoSum_hashMap(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>(); // key为元素，value为元素的下标
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                return new int[]{record.get(target - nums[i]), i}; // 获取record中key对应的value，获取当前元素的下标
            }
            record.put(nums[i], i);
        }
        throw new IllegalArgumentException("nums参数异常");
    }
}
