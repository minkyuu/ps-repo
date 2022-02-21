// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        if (Arrays.stream(numbers).filter(i -> i == 0).count() == numbers.length)
            return "0";

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            temp.add(Integer.toString(numbers[i]));
        }

        temp.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.charAt(0) > o1.charAt(0)){
                    return 1;
                } else if (o2.charAt(0) < o1.charAt(0)){
                    return -1;
                } else {
                    if (o2.length() == o1.length())
                        return Integer.parseInt(o2) - Integer.parseInt(o1);
                    return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
                }
            }
        });

        for (int i = 0; i < temp.size(); i++) {
            answer += temp.get(i);
        }

        return answer;
    }
}
