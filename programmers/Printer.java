// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Location> q = new LinkedList<>();

        for (int i = 0 ; i < priorities.length; i++) {
            Location temp = new Location();
            temp.index = i;
            temp.priority = priorities[i];
            q.add(temp);
        }

        Arrays.sort(priorities);
        int idx = priorities.length - 1;

        while(!q.isEmpty()){
            Location temp = q.poll();
            if(priorities[idx] == temp.priority){
                if (temp.index == location){
                    return ++answer;
                }
                answer++;
                idx--;
            }
            q.add(temp);
        }

        return answer;
    }

    private static class Location {
        int priority;
        int index;
    }
}
