package hashTable;

import java.util.Arrays;

/**
 * @Description 有效字母异位相等（字符串排序后相等）
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明: 你可以假设字符串只包含小写字母。
 * @Author Phil
 * @CreateTime 2022/6/12
 **/

public class IsAnagram {
    public static void main(String[] args) {
        boolean anagram_hash = new IsAnagram().isAnagram_int("anagram", "nAgraam");
        System.out.println(anagram_hash);
        System.out.println(anagram_hash);

    }

    // 暴力排序
    private boolean isAnagram(String s, String t) {
        // 转换为字符数组
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        // 排序
        Arrays.sort(s1);
        Arrays.sort(t1);
        // 判断排序后是否相等
        return Arrays.equals(s1, t1);
    }

    // 用数组做哈希表
    private boolean isAnagram_hash(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] record = new int[26];

        // 遍历s
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        // 遍历t
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        // 遍历record的每个元素是否为0，不为0返回false（说明不是字母异位词）
        for (int item : record) {
            if (item != 0) return false;
        }
        return true;
    }

    // 优化
    private boolean isAnagram_int(String s, String t) {
        if (s.length() != t.length()) return false;
        int record = 0;

        char[] sRecord;
        char[] tRecord;
        sRecord = s.toCharArray();
        tRecord = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            record += sRecord[i] - tRecord[i];
        }

        // 遍历record的每个元素是否为0，不为0返回false（说明不是字母异位词）
        return record == 0;
    }
}
