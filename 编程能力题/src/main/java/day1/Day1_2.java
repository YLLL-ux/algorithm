package day1;

import java.util.Arrays;

/**
 * @Description 去掉最低工资和最高工资后的工资平均值
 * <p>
 * 给你一个整数数组salary，数组里每个数都是唯一的，其中salary[i] 是第i个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * 示例 2：
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * <p>
 * 示例 3：
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * @Author Phil
 * @CreateTime 2022/5/14
 **/

public class Day1_2 {
    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        double average = average(salary);
        System.out.println(average);
    }

    /**
     * 对数组进行排序，掐头去尾，然后计算平均值
     */
    public static double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        int length = salary.length;
        for (int i = 1; i < length - 1; i++) {
            sum += salary[i];
        }
        return sum / (length - 2);
    }
}
