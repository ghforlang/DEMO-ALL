package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @version 1.0
 * @Date 2021/6/25 10:35 上午
 * 最长无重复子串的长度,
 * @since 1.0
 */
public class Problem3 {
    private static final String[] strs = {"abcabcbb","bbbbb","pwwkew","","abcdefcdefc"};
    private static final int[] results = {3,1,3,0,6};

    private static final String[] strs1 = {"abcdefcdefc"};
    private static final int[] results1 = {6};
    public static void main(String[] args) {
        for(int i = 0;i<strs.length;i++){
            System.out.println( strs[i] + " : " + lengthOfLongestSubstring2(strs[i]) + " , answer:" + results[i]);
        }
    }

    // 滑动窗口，维护左右两个指针，移动右指针，并记录每个字符位置，
    // 有重复则左指针位置调整为重复字符所在位置+1，更新重复字符位置；循环，直至右指针达到字符串末尾。
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int start = 0,end = 0;
        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        while(end < s.length()){
            // 记录当前最大长度
            result = result > (end - start) ? result : (end - start);
            if(map.get(s.charAt(end)) != null && map.get(s.charAt(end)) >= start){
                start = map.get(s.charAt(end)) + 1;
            }
            // 记录字符下标,更新重复字符下标
            map.put(s.charAt(end),end);
            end ++;
        }
        result = result > (end - start) ? result : (end - start);
        return result;
    }

    // 优化版，用字符桶代替map，减少内存使用
    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int start = 0,end = 0;
        // 字符桶，用于存放字符在s中的最新下标,默认初始值-1
        int [] bucket = new int[128];
        for(int i = 0;i<bucket.length;i++){
            bucket[i] = -1;
        }
        int result = 0;
        while(end < s.length()){
            // 记录当前最大长度
            result = result > (end -start) ? result : (end -start);
            int temp = s.charAt(end);
            if(bucket[temp] >= start ){
                start = bucket[temp] + 1;
            }
            // 记录字符下标,更新重复字符下标
            bucket[temp] = end;
            end ++;
        }
        result = result > (end -start) ? result : (end -start);
        return result;
    }
}
