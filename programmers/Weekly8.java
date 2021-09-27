// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/86491

class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0;
        int lengthMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if (sizes[i][0] > widthMax)
                widthMax = sizes[i][0];
            if (sizes[i][1] > lengthMax)
                lengthMax = sizes[i][1];
        }
        return widthMax * lengthMax;
    }
}