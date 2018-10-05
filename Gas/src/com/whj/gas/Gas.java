package com.whj.gas;

import java.util.Arrays;
import java.util.Scanner;

public class Gas extends Object{
	
    static int MAX = 9999;
    static int N,K,A,B,C; 
    static int[][] flag ={{1,0,B},{0,1,B},{-1,0,0},{0,-1,0}};
    static int[][] point;
    static int[][] price;
    static int[][] len;
	public static void main(String[] args) {
       Scanner sca = new Scanner(System.in);
       N = sca.nextInt();
       K = sca.nextInt();
       A = sca.nextInt();
       B = sca.nextInt();
       C = sca.nextInt();
       flag[0][2] = B;
       flag[1][2] = B;
   
       point = new int[N+1][N+1];
       price = new int[N+1][N+1];
       len   = new int[N+1][N+1];
	   for(int i=1;i<=N;i++)
		   for(int j=1;j<=N;j++)
			   { 
			    point[i][j] = sca.nextInt();	
			    price[i][j] = MAX;
			    len[i][j] = K;
			   }
	   
	   System.out.println(gasCalculate()); 
	}
	public static  int gasCalculate(){
		 for(int i=0;i<4;i++) {
			   for(int j=0;j<3;j++)
				   { 
				    System.out.print(flag[i][j]+" ");
				   }
			   System.out.println();   
	       }
       price[1][1] = 0;
       len[1][1] = K;
       int i,j,k;
       int x,y;
       boolean judge = false;
       while(!judge) {
    	   judge = true;
    	   for(i=1;i<=N;i++) {
    		   for(j=1;j<=N;j++){
    			   if(i==1&&j==1)
                 	  continue;
    			  int minPrice = MAX,minDistance = MAX;
    		      int reaPrice,driDistance; 
                  for(k=0;k<4;k++){
                	  x =i+flag[k][0];
                	  y =j+flag[k][1]; 
                	  if(x<1||y<1||x>N||y>N)
                		  continue;
                	  reaPrice = price[x][y] + flag[k][2];
                	  driDistance = len[x][y]-1;
                	  if(point[i][j]==1) {
                		  reaPrice+=A;
                		  driDistance =K;
                	  }
                	  if(point[i][j]==0&&driDistance==0&&(i!=N||j!=N)){
                          reaPrice=reaPrice+A+C;       		  
                          driDistance =K;
                	  }
                	  if(reaPrice<minPrice) {
                		  minPrice = reaPrice;
                		  minDistance = driDistance; 
                	  }
                  } 
                  if(price[i][j]>minPrice) {
                 	  price[i][j] = minPrice;
                 	  len[i][j] = minDistance;
                   }
    		   }
    		 }
       } 
       return price[N][N];

        
	}
}
 