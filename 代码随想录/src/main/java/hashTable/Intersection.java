package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 两个数组的交集.
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * @Author Phil
 * @CreateTime 2022/6/14
 **/

public class Intersection {

    // hashSet（去重），用set做哈希表
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 遍历nums1
        for (int item : nums1) {
            set1.add(item);
        }

        // 遍历nums2，如果在set1中存在则添加进set2
        for (int item : nums2) {
            if (set1.contains(item)) set2.add(item);
        }

        // 返回的数组
        int[] reArr = new int[set2.size()];
        int index = 0;
        for (int item : set2) {
            reArr[index++] = item;
        }

        return reArr;
    }
}
