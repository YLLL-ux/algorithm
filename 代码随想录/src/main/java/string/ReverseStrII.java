package string;

/**
 * @Description 反转字符串II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * @Author Phil
 * @CreateTime 2022/7/7
 **/

public class ReverseStrII {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String reverseStr = new ReverseStrII().reverseStr(s, k);
        System.out.println(reverseStr);
    }

    public String reverseStr(String s, int k) {
        // 将字符转转为字符数组
        char[] charStr = s.toCharArray();

        // 遍历字符数组，间隔 i=i+(2*k) 因为每隔 2k个就反转前 k个，所以每次反转的起点为 i=i+(2*k) 处。
        for (int i = 0; i < charStr.length; i += 2 * k) {
            // 起点指针
            int start = i;
            // 终点指针，判断尾数够不够k个来取决end指针的位置
            int end = Math.min(charStr.length - 1, start + k - 1);

            // 翻转字符
            while (start < end) {
                charStr[start] ^= charStr[end];
                charStr[end] ^= charStr[start];
                charStr[start] ^= charStr[end];

                start++;
                end--;
            }
        }
        return new String(charStr);
    }
}
