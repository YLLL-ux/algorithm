package string;

/**
 * @Description 实现Strstr
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf()定义相符。
 * <p>
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * @Author Phil
 * @CreateTime 2022/7/11
 **/

public class Strstr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new Strstr().strStr(haystack, needle));
    }

    /**
     * 暴力解法
     * <p>
     * 将 needle与长度为 haystack中长度为 n的子串进行比较。
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true; // 是否出现needle
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
                ;
            }

            if (flag) return i;
        }
        return -1;
    }
}
