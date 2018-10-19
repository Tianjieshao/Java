package com.whj.bag;

import java.util.Scanner;

public class Bag {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("请输入物品的个数:");
		int n = sca.nextInt();
		System.out.println("请输入背包的重量:");
		int c = sca.nextInt();
		int m[][] = new int[n+1][c+1];
		int w[] = new int[n+1];
		int v[] = new int[n+1];
		int x[] = new int[n+1];
		w[0] = 0;
		v[0] = 0;
		System.out.println("请输入每件物品的重量及价值:");
		for(int i=1;i<=n;i++) {
           	  w[i]= sca.nextInt();
              v[i]= sca.nextInt();
		}
		Knapsack(v,w,c,n,m);
		Trackback(m,w,c,n,x);
		System.out.println(m[1][c]);
		System.out.println("物品的装入情况如下:");
		for(int i=1;i<=n;i++)
		{
			if(x[i] == 1)
				System.out.println(i+"号物品被装入");
		}
	}
    public static void Knapsack(int v[],int w[], int c,int n,int m[][]) {
    	int jMax = (w[n]-1)<c ? (w[n]-1)  : c;
    	for(int j=0;j<=jMax;j++) m[n][j] = 0;
    	for(int j=w[n];j<=c;j++) m[n][j] = v[n];
    	for(int i=n-1;i>1;i--){
    		jMax = (w[i]-1)<c ? (w[i]-1)  : c;
    		for(int j=0;j<=jMax;j++)
    			m[i][j] = m[i+1][j];
            for(int j=w[i];j<=c;j++)
                m[i][j] = m[i+1][j]<(m[i+1][j-w[i]]+v[i]) ? (m[i+1][j-w[i]]+v[i]) : m[i+1][j];
    		}
    	m[1][c] = m[2][c];
    	if(c>=w[1]) 
    		m[1][c] = m[1][c]<(m[2][c-w[1]]+v[1]) ? (m[2][c-w[1]]+v[1]) : m[1][c];
    } 
    static void Trackback(int m[][],int w[],int c,int n,int x[]){
    	for(int i=1;i<n;i++) {
    		if(m[i][c]==m[i+1][c]) x[i] = 0;
    		else {
    			x[i] =1;
    			c-= w[i];
    		}
    		x[n] = (m[n][c]!=0) ? 1: 0;
    	}
    }

}
