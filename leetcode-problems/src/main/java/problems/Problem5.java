package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/25 2:35 下午
 * @since 1.0
 * 最长回文子串
 */
public class Problem5 {

    public static final String[] strs = {"a","aa","ab","abcdcbae","cbbd"};
    public static void main(String[] args) {
        for(String s : strs){
            System.out.println(s + " : " + longestPalindrome3(s));
        }

    }

    //动态规划版本，也比较容易理解
    public static String longestPalindrome3(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        if(s.length() < 2){
            return s;
        }

        int maxLength = 1;
        int begin = 0;
        //动态规划数组，用于记录当前[i,j]子串是否为回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化长度为1的子串dp值
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
        }

        //枚举子串长度
        for(int L = 2;L <= s.length();L ++){
            //枚举左边界
            for(int i = 0;i < s.length() ; i++){
                int j = L + i - 1;
                if(j >= s.length()){
                    break;
                }

                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    //长度为1-2的子串，此时必为回文子串
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        // 否则，当前串状态与上一子串状态一致
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 更新最大长度与起始位置
                if(dp[i][j] && (j- i + 1) > maxLength){
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }

    // 中心拓展法，更容易理解
    public static String longestPalindrome2(String s){
        if(s == null || s.length() ==0){
            return "";
        }
        int maxLen = 0;
        // 标记当前最长回文子串的起始位置,[start,end]闭区间
        int start = 0,end = 0;
        for(int i=0;i<s.length();i++){
            // 长度为奇数，即有回文中心，的字符串中，最长回文子串长度，
            int len1 = length(s,i,i);
            int len2 = length(s,i,i+1);
            maxLen = len1 > len2 ? len1 : len2;
            // 若maxLen超过闭区间长度，更新闭区间，闭区间与当前i值相关
            if(maxLen > end - start){
                // len-1，兼容奇偶，比如maxLen = 4，i=2,start = 2 - 1 = 1
                start = i - (maxLen -1) / 2;
                // 闭区间，所以
                end = i + maxLen / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    //辅助方法 计算[left,right]子串中最大回文子串长度
    private static int length(String s,int left,int right){
        // 以left、right为中心的字符串是回文子串，则分别移动左右指针
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        // left、right指针此时可能已经移动，故长度为right-left -1；
        return right - left - 1;
    }

    // 中心拓展法,
    public static String longestPalindrome1(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        char[] charArray = s.toCharArray();
        int start = 0;
        // 遍历出所有长度大于1的子串，然后判断子串是否是回文串，且长度大于当前最大长度，作为最终结果
        for(int i=0 ; i<len-1 ; i ++){
            for(int j= i+1 ; j<len ; j++){
                if(j-i + 1 > maxLen && isPalindrome(charArray,i,j)){
                    maxLen = j-i+1 ;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    // 暴力方法
    public static  String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        char[] charArray = s.toCharArray();
        int start = 0;
        // 遍历出所有长度大于1的子串，然后判断子串是否是回文串，且长度大于当前最大长度，作为最终结果
        for(int i=0 ; i<len-1 ; i ++){
            for(int j= i+1 ; j<len ; j++){
                if(j-i + 1 > maxLen && isPalindrome(charArray,i,j)){
                    maxLen = j-i+1 ;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    private static boolean isPalindrome(char[] array,int left,int right){
        while(left < right){
            if(array[left] != array[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

}
