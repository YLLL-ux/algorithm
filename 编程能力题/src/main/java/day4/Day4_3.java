package day4;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 快乐数.
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * @Author Phil
 * @CreateTime 2022/5/18
 **/

public class Day4_3 {
    public static void main(String[] args) {
        System.out.println(new Day4_3().isHappy(2));
    }

    public boolean isHappy(int n) {
        // 使用hashSet记录每个n
        Set<Integer> integers = new HashSet<>();
        while (n != 1 && !integers.contains(n)) {
            integers.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 获取下一个数
     *
     * @param n 当前整数
     * @return 下一个数
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int temp = n % 10; // 9
            n = n / 10; // 78
            totalSum += temp * temp; // 0+(9^2)+(8^2)+(7^2) 以此类推
        }
        return totalSum;
    }
}
