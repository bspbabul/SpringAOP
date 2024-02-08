package com.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		boolean flag = true;
		while(flag) {
			boolean add = list.add(scanner.nextInt());
			if(add==false) {
				flag=false;
			}
		}
		System.out.println(list);
	}

}
