// 문제 링크 : https://leetcode.com/problems/sorting-the-sentence/

import java.util.StringTokenizer;

class Solution {
    public static String sortSentence(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");

        int length = st.countTokens();
        String[] result = new String[length];

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            int idx = temp.charAt(temp.length()-1) - 48;
            result[idx-1] = temp.substring(0, temp.length() - 1);
        }
        return String.join(" ", result);
    }
}