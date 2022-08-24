package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 四数相加II.
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 有2种情况
 * <p>
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * @Author Phil
 * @CreateTime 2022/6/16
 **/

public class FourSumCountII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int count = new FourSumCountII().fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(count);
    }

    // 用map做哈希表。分组+哈希表
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // map中 key=i+j,value=i+j 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 记录满足条件的次数
        int record = 0;

        // 遍历nums1、nums2
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i + j;
                // 判断 i+j是否已经存在map中
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        // 遍历nums3、nums4
        for (int k : nums3) {
            for (int l : nums4) {
                int temp = k + l;
                if (map.containsKey(-temp)) {
                    record += map.get(-temp);
                }
            }
        }
        return record;
    }
}
