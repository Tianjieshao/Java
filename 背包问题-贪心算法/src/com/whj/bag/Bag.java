package com.whj.bag;

import java.util.Arrays;
import java.util.Scanner;

public class Bag {

	public static void main(String[] args) {
		int n,M;
		Scanner sca = new Scanner(System.in);
		System.out.println("请输入物品的总数量：");
		n = sca.nextInt();
		System.out.println("请输入背包的总重量：");
		M = sca.nextInt();
		float v[] = new float[n];
		float w[] = new float[n];
	    float x[] = new float[n];
	    System.out.println("请输入各物品的重量和价值：");
	    for(int i=0;i<n;i++) {
	    	w[i] = sca.nextFloat();
	        v[i] = sca.nextFloat();
	    }
	    System.out.println(put(n,M,v,w,x));
	    
	}
	public static float put(int n,float M,float v[],float w[],float x[]){
		int i;	
		float value = 0;
		float c= M;
		for(i=0;i<n;i++) {
			x[i] = 0;
		}	
	    sort(n,v,w);
		for(i=0;i<n;i++) {
			if(c<w[i])
				break;
			c-=w[i];
			x[i] = 1;
			value+=v[i];
		}
		if(i<=n-1){
			x[i] = c/w[i];
		    value+=x[i]*v[i];
		}
		return value;
	}
	public static void sort(int n,float v[],float w[]) {
		float a,t;
        int flag = 1,m=n-1;
        
        while((m>1)&&(flag==1)) {
        	flag =0;
        	for(int i=0;i<m;i++) {
        		if((v[i]/w[i])<(v[i+1]/w[i+1]))
        		{
        			flag =1;
        			t = v[i];
        			v[i] = v[i+1];
        			v[i+1] = t;
        			
        			t = w[i];
        			w[i] = w[i+1];
        			w[i+1] = t;
        		}
        	}
        	--m;
        	
        }
        

	}

}
