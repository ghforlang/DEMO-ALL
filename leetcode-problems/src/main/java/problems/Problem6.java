package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @version 1.0
 * @Date 2021/6/28 10:54 上午
 * @since 1.0
 */
public class Problem6 {
    private static final String[] strs = {"ABCDEFGHI","PAYPALISHIRING","A","AB"};
    public static void main(String[] args) {
        for(int i=0;i< strs.length;i++){
            System.out.println(strs[i] + " -> " + convert(strs[i],3));
        }
    }

    private static final String[] subStr(String s,int numRows){
        int subStrLen = 0;
        if(s == null || s.length() == 0 || numRows <= 0 ){
            return null;
        }
        subStrLen = s.length() / numRows + (s.length() % numRows == 0 ? 0 : 1);
        String[] subStrs = new String[subStrLen];
        int step = 2*numRows - 2;
        int start = 0;
        for(int i=0;i<subStrLen-1;i++){
            start = i * step;
            subStrs[i] = s.substring(start,start + step);
        }
        start += step;
        subStrs[subStrLen-1] = s.substring(start);
        return subStrs;
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows<2){
            return s;
        }

        List<StringBuilder> sbList = new ArrayList<>(numRows);
        for (int i=0;i< numRows ;i++){
            sbList.add(new StringBuilder());
        }

        int startRow = 0,flag = -1;
        for(char c : s.toCharArray()){
            sbList.get(startRow).append(c);
            if(startRow == 0 || startRow == (numRows-1)){
                flag = -flag;
            }
            startRow+= flag;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder ss : sbList){
            sb.append(ss);
        }
        return sb.toString();
    }

    private static char[][] buildCharArray(String s,int numRows){
        int length = s.length();
        int numColums = (numRows - 1 ) * length / (2*(numRows - 1));
        int mod = length % (2*numRows - 2) ;
        if(mod > 0 && mod <= numColums){
            numColums ++;
        }else if(mod > numColums && mod < 2*numRows - 2){
            numColums += (mod - numColums + 1);
        }
        char[][] result = new char[numRows][numColums];

        // 截成长度为2n-1的子串
        String[] subStrs = subStr(s,numRows);
        for(int i=0;i<subStrs.length;i++){
            String subStr = subStrs[i];
            int curStartColumn = i*(numRows-1);
            for(int j=0;j<subStr.length();j++){
                int curStartRow = 0;
                int leftLen = subStr.length() / numRows;
                int modLen = subStr.length() % numRows;
                if(leftLen > 0){
                    for (int k = 0;k<numRows;k++){
                        result[curStartRow++][curStartColumn] = subStr.charAt(k);
                    }
                    if(modLen>0){
                        for(int k = 0;k<modLen;k++){
                            result[--curStartRow][++curStartColumn] = subStr.charAt(k+numRows);
                        }
                    }
                }else{
                    if(modLen>0){
                        for(int k = 0;k<modLen;k++){
                            result[curStartRow++][curStartColumn] = subStr.charAt(k+numColums);
                        }
                    }
                }
            }
        }
        return result;
    }
}
