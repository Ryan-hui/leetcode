//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
public class longestPalindrome_5 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        boolean[][] bp = new boolean[len][len];
        //init
        for(int i = 0 ; i < len; i++){
            bp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;

        for(int right = 1; right < len; right++){
            for(int left = 0; left < right; left++){

                if(s.charAt(left) == s.charAt(right)){
                    if(right-1 - (left + 1) + 1 < 2){
                        bp[left][right] = true;
                    }else{
                        bp[left][right] = bp[left+1][right-1];
                    }
                }

                if(bp[left][right]){
                    int curLen = right - left + 1;
                    if(curLen >= maxLen){
                        maxLen = curLen;
                        start = left;
                    }
                }
            }
        }

        return s.substring(start,start + maxLen);
    }

    public static void main(String[] args){
        String input1 = "babad";
        String input2 = "cbbd";
        String input3 = "abbbbc";
        System.out.println("输入为babad的输出为： " + longestPalindrome_5.longestPalindrome(input1));
        System.out.println("输入为cbbd的输出为： " + longestPalindrome_5.longestPalindrome(input2));
        System.out.println("输入为abbbbc的输出为： " + longestPalindrome_5.longestPalindrome(input3));

    }
}

