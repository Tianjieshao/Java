package com.whj.mergesort;
import static java.lang.Math.*;
import java.util.*;
public class MergeSort {
	public static void main(String[] args){
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
		MergeSort mer = new MergeSort();
		mer.mergesort(a,number);
		for(int i = 0;i<number;i++) {
			System.out.print(a[i]+" ");
		}
	} 
	public void mergesort(int array[],int n) {
		int[] b = new int[n];
		
        int s =1;
        while(s<n) {
        	mergePass(array,b,s,n);
        	s +=s;
        	mergePass(b,array,s,n);
        	s +=s;
        }
	}
	void mergePass(int array1[],int array2[],int s,int n) {
		int i =0;
		while(i<=n-2*s) {
			//合并大小为s的相邻2段子数组
			merge(array1,array2,i,i+s-1,i+2*s-1);
			i = i+2*s;
		}
		if(i+s<n) merge(array1,array2,i,i+s-1,n-1);
		else for(int j =i;j<=n-1;j++)
			array2[j] = array1[j];
	}
	
	void merge(int array1[],int array2[],int l,int m,int r) {
		int i = l,j = m+1,k = l; //合并array1[l:m]和array1[m+l:r]到array2[l:r]
		while((i<=m)&&(j<=r)) 
			if(array1[i]<=array1[j])
				array2[k++] = array1[i++];
			else
				array2[k++] = array1[j++];
			if(i > m) 
				for(int q = j; q<=r;q++)
				  array2[k++] = array1[q];	
			else 
				for(int q=i; q<= m;q++)
				  array2[k++] = array1[q];	
		}	
	
}
