package com.whj.program;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
public class Program {
public static void main(String[] args) throws IOException {
storage();}
  public static void storage() throws IOException {
  File file = new File("D:/input.txt");
 BufferedReader reader = null;
 reader = new BufferedReader(new FileReader(file));
  String tempString = null;     
  String a="";      
 while((tempString = reader.readLine())!=null) {
   a=a.concat(tempString+" ");       
}       
String []c =a.split(" ");       
 int num[] = new int[c.length];    
 for(int i=0;i<c.length;i++) {   
Integer temp = (Integer.parseInt(c[i]));
num[i]  = temp.intValue();
 }   
int flag = 1,t;
 int m = num.length;
while((m>0)&&(flag==1)){
   flag =0;
for(int j=2;j<m-1;j++){
if(num[j]>num[j+1]){
flag = 1;
t = num[j];
num[j] = num[j+1];
num[j+1] = t;
}
}
--m;
}
int sum=0;
int count=0;
for(int j=2;j<num.length;j++){
  if((sum+num[j])>num[1]){
  break;
  }
  sum+=num[j];
  count++;

  }
File output = new File("D:/output.txt");
FileOutputStream fos = new FileOutputStream(output);
        fos.write(count);
    fos.close();
} 
}
