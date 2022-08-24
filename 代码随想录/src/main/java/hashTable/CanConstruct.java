package hashTable;

/**
 * @Description 赎金信。
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * @Author Phil
 * @CreateTime 2022/6/18
 **/

public class CanConstruct {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        boolean construct = new CanConstruct().canConstruct_hash(ransomNote, magazine);
        System.out.println(construct);
    }

    /**
     * 暴力解法
     *
     * @param ransomNote 结果
     * @param magazine   元数据
     * @return boolean
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 将元数据转为char[]
        char[] letters = magazine.toCharArray();

        // 目标数据
        for (int i = 0; i < ransomNote.length(); i++) {
            boolean isMatch = false;
            // 遍历元数据数组
            for (int j = 0; j < letters.length; j++) {
                if (ransomNote.charAt(i) == letters[j]) {
                    letters[j] = 0; // 保证 magazine 中的每个字符只能在 ransomNote 中使用一次
                    isMatch = true;
                    break;
                }
            }

            // 找一圈没有找到，返回false
            if (!isMatch) {
                return false;
            }
        }
        return true;
    }

    // 用数组做哈希表
    public boolean canConstruct_hash(String ransomNote, String magazine) {
        // 用int[26]记录元数据(magazine)中每个字母出现的次数
        int[] record = new int[26];

        // 遍历magazine
        for (int m : magazine.toCharArray()) record[m - 'a'] += 1;
        // 遍历ransomNote
        for (int r : ransomNote.toCharArray()) record[r - 'a'] -= 1;

        // 如果record中出现-1，则说明不能组成,即字母个数不够
        for (int rec : record) {
            if (rec < 0) {
                return false;
            }
        }

        return true;
    }
}
