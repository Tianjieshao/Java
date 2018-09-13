package com.whj.kuaipai;

import static java.lang.Math.random;
import static java.lang.Math.round;

import java.util.Scanner;



public class KuaiPai {
	public static void main(String[] args) {
		int number;	
		System.out.println("请输入待排序数组的个数：");
		Scanner sca = new Scanner(System.in);
		number = sca.nextInt();
		int[] a = new int[number];
		for(int i = 0;i<number;i++) {
			a[i] = (int)(round(random()*100));
		}
		for(int i = 0;i<number;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		KuaiPai kp = new KuaiPai();
		kp.QuickSort(a,0,number-1);
		for(int i = 0;i<number;i++) {
			System.out.print(a[i]+" ");
		}
		
		
	} 
	void QuickSort(int a[],int p,int r) {
		if(p<r) {
			int q = Partiton(a, p, r);
			QuickSort(a,p,q-1);
			QuickSort(a,q+1,r);
		}
		 
	}
	public int Partiton(int a[],int p,int r) {
		int i = p, j=r+1;
		int x = a[p];
		
		int t;
		while(true) {
			while(a[++i]<x&&i<r);
			while(a[--j]>x);
			if(i>=j) break;
			t= a[i];
			a[i] = a[j];
			a[j] = t;
			
		}
	   a[p]=a[j];
	   a[j] = x;
		return j;

	}
}
