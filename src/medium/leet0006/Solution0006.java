package medium.leet0006;

import java.util.ArrayList;
import java.util.List;

public class Solution0006 {
    /**
     * Z字形变换
     * <p>
     * 从左往右迭代s，将每个字符串添加到合适的行。可以使用当前行
     * 和当前方向这两个变量对合适的行进行跟踪。
     *
     * @param s       变换前字符串
     * @param numRows 限定行数
     * @return 转换后的字符串
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        //初始化行向量
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        //按行逐个添加字符到相应的行向量中
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //当curRow == 0或者curRow == numRows - 1时，改变当前方向
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            //改变当前行
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(new Solution0006().convert(s, 4));
    }
}
