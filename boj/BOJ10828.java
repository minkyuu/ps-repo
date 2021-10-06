// 문제 링크 : https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	
	public static void main(String[] args) throws IOException{
		Stack stack = new Stack();
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[] result = new int[num];
		int idx = 0;
		
		for(int i = 0; i<num; i++) {
			String std = br.readLine();
			
			if(std.length() == 3) {
				if(std.charAt(0)=='t') {
					if(!stack.isEmpty()) {
						result[idx++] = (int) stack.peek();	
					}else
						result[idx++] = -1;			
				}else {
					if(!stack.isEmpty()) {
						result[idx++] = (int) stack.pop();
					}else 
						result[idx++] = -1;
				}	
			}
		
			if(std.length() == 4) {
				result[idx++] = stack.size(); 
			}
			
			if(std.length() == 5) {
				result[idx++] = stack.isEmpty()? 1: 0;
			}
			
			if(std.length() >= 6) {
				int input = Integer.parseInt(std.substring(5));
				stack.push(input);
			}
		}
		br.close();
		
		for(int i =0; i<idx;i++) {
			System.out.println(result[i]);
		}
	}
}
