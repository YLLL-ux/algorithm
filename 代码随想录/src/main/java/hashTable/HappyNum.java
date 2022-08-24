package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 快乐数.
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 02 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * @Author Phil
 * @CreateTime 2022/6/14
 **/

public class HappyNum {

    public static void main(String[] args) {
        System.out.println(new HappyNum().isHappy(19));
    }

    // 用set做哈希表
    public boolean isHappy(int n) {
        // 记录n是否已经存在
        Set<Integer> record = new HashSet<>();
        while (!record.contains(n) && n != 1) {
            record.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
