package string;

/**
 * @Description 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * @Author Phil
 * @CreateTime 2022/7/9
 **/

public class ReverseLeftWords {

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        String s1 = new ReverseLeftWords().reverseLeftWords(s, n);
        System.out.println(s1);
    }

    public String reverseLeftWords(String s, int n) {
        int length = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        // 翻转前n个子串
        reverseString(sb, 0, n - 1);
        // 翻转n到末尾的子串
        reverseString(sb, n, length);
        // 翻转整个字符串
        return sb.reverse().toString();
    }

    private void reverseString(StringBuilder str, int start, int end) {
        while (start < end) {
            char temp = str.charAt(start);  // 获取start处的字符
            str.setCharAt(start, str.charAt(end)); // 将start处的字符修改为str.charAt(end)
            str.setCharAt(end, temp); // 将end处字符修改为temp
            start++;
            end--;
        }
    }
}
