package com.whj.rope;

import java.util.Scanner;

public class Rope {
	public static void main(String[] args) {
		System.out.println("请输入绳子的长度");
		Scanner sca = new Scanner(System.in);
		int length = sca.nextInt();
		System.out.println(maxCutRope(length));	
	}
	static int maxCutRope(int length) {
		int max,sum;
		if(length==0) return 0;
		if(length==1) return 1;
		if(length==2) return 1;
		if(length==3) return 2;
		int a[] = new int[length+1];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		
		for(int i=4;i<=length;i++) {
			max =0;
			for(int j=1;j<=i/2;j++) {
				sum = a[j]*a[i-j];
			    if(sum>max)
			    	max = sum;
			}
			a[i] = max;
		}
		return a[length];
	}
}
