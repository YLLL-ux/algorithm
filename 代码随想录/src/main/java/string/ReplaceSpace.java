package string;

/**
 * @Description 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @Author Phil
 * @CreateTime 2022/7/7
 **/

public class ReplaceSpace {

    // 方法一：遍历添加
    public String replaceSpace(String s) {
        if (s == null) return s;

        StringBuilder strBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') strBuilder.append("%20");
            else strBuilder.append(c);
        }

        return strBuilder.toString();
    }

    // 双指针
    public String replaceSpace2(String s) {
        if (s.length() == 0) return s;

        StringBuilder newStr = new StringBuilder();
        // 扩展长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newStr.append("  ");
            }
        }

        // 如果没有空格不扩展
        if (newStr.length() == 0) return s;

        // 定义左右指针
        int leftIndex = s.length() - 1;
        s += newStr;
        int rightIndex = s.length() - 1;
        char[] chars = s.toCharArray();

        // 替换
        while (leftIndex >= 0) {
            if (chars[leftIndex] == ' ') { // 空格进行替换
                chars[rightIndex--] = '0';
                chars[rightIndex--] = '2';
                chars[rightIndex] = '%';
            } else {
                chars[rightIndex] = chars[leftIndex];
            }
            leftIndex--;
            rightIndex--;
        }
        return new String(newStr);
    }
}
