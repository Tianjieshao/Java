package project;

import java.util.*;
class pointInformation{
	int x;
	int y;
}//定义点类型的一个类
public class NearestPoints {
	static int pointNumber;
	pointInformation p;
	pointInformation q;
	public void printValue(pointInformation points[],int number) {
		for(int i=0;i<number;i++)			
			{
			  System.out.printf("("+points[i].x+","+points[i].y+") ");
			}
		    System.out.println();		
	}
   
	public static double distance(int x1,int y1,int x2,int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	public void sortxLength(pointInformation points[],int number) {//冒泡排序法
		int flag =1;
		int t,j;
		int m = number;
		while((m>0)&&(flag==1)) {
			flag = 0;
		for(j=0;j<m-1;j++)
		{
			if(points[j].x>points[j+1].x)
			{
		      flag = 1;		
			  t = points[j].x;
			  points[j].x = points[j+1].x;
			  points[j+1].x = t;
			}
			
		}
		   --m;
		}
	}
	
    public double closePoints(pointInformation points[],int number,pointInformation a,pointInformation b,NearestPoints nearestPoints) {
    	double d1,d2,dis;
    	pointInformation  a1= new pointInformation();
    	pointInformation  a2= new pointInformation();
    	pointInformation  b1= new pointInformation();
    	pointInformation  b2= new pointInformation();
    	pointInformation[]  points1= new pointInformation[number];
    	pointInformation[]  points2= new pointInformation[number];
    	pointInformation[]  points3= new pointInformation[number];
    	if(number<2) {
    	    return 20000;
    	}
    	 if(number==2)
    	    {
    		    a=points[0];
    		    b=points[1];
    		    nearestPoints.p = a;
    		    nearestPoints.q = b;
    	        dis=distance(points[0].x,points[0].y,points[1].x,points[1].y);
    	        return dis;
    	    }
    	else {
    		sortxLength(points,number);
    		//printValue(points);
    		int mid = number/2-1;//分割线的横坐标
    	    for(int i=0;i<=mid;i++)
    	    {
    	    	 points1[i] = points[i];
    	    }
    	    for(int i= mid+1,j=0;i<number;i++,j++)
    	    {
    	    	 points2[j] = points[i];
    	    }
    	    d1=closePoints(points1,mid+1,a1,b1, nearestPoints);           //分治求解左半部分子集的最近点  
            d2=closePoints(points2,number-mid-1,a2,b2, nearestPoints);    //分治求解右半部分子集的最近点  
            if(d1<d2) { dis=d1; a=a1; b=b1;}
            else { dis=d2; a=a2; b=b2;}
            int k =0;   
            for(int i=0;i<number;i++)
                if(Math.abs(points[i].x-points[mid].x)<=dis)
                	points3[k++]=points[i]; //求解跨分割线并在区间内的最近点对
    			
            for(int i=0;i<k;i++)
                for(int j=i+1;j<=i+7&&j<k;j++)    //只需与有序的领接的的7个点进行比较
                {
                    if(distance(points3[i].x,points3[i].y,points3[j].x,points3[j].y)<dis)
                    {//如果跨分割线的两点距离小于已知最小距离，则记录该距离
                        dis=distance(points3[i].x,points3[i].y,points3[j].x,points3[j].y);
                        a=points3[i];
                        b=points3[j];
                        nearestPoints.p = a;
            		    nearestPoints.q = b;
                    }
                }
        }
    	  	 
    	 

            return dis;
    	}
	public static void main(String[] args) {
	
		pointInformation  a = new pointInformation();
	    pointInformation  b = new pointInformation();
		NearestPoints nearestPoints = new NearestPoints();
		System.out.println("请输入你想测试的点对个数:");
		Scanner scanner = new Scanner(System.in);
		pointNumber = scanner.nextInt();
		pointInformation[]  points= new pointInformation[pointNumber];

		for(int i=0;i<pointNumber;i++)
			{
			   points[i] = new 	pointInformation();/**没有这句话会报空指针错误，你定义了对象数组里面的都为null，必须new一个Chess的实例才行 **/
			   points[i].x = (int)Math.round(Math.random()*100);
			   points[i].y = (int)Math.round(Math.random()*100);
			}
		nearestPoints.printValue(points,pointNumber);
		double dis = nearestPoints.closePoints(points,pointNumber,a,b,nearestPoints);
    	System.out.print("第一个点的坐标为:("+nearestPoints.p.x+","+nearestPoints.p.y+") ");
 		System.out.println("第二个点的坐标为：("+nearestPoints.q.x+","+nearestPoints.q.y+") ");
		System.out.println(dis);
	//	nearestPoints.printValue(points);
		return ;
	}
}

