#include <iostream>
using namespace std;
void LCSLength(int m,int n,char x[],char y[],int c[][100],int b[][100]){
   int i,j;
   for(i=0;i<=m;i++) c[i][0] = 0;
   for(i=1;i<=m;i++) c[0][i] = 0;
   for( i =1;i<=m;i++)
    for(j =1;j<n;j++)
      if(x[i]==y[j]){
        c[i][j] =c[i-1][j-1]+1;
        b[i][j] =1;
      }
      else if(c[i-1][j]>c[i][j-1])
      {
        c[i][j] = c[i-1][j]; b[i][j] =2;
      }
      else if(c[i-1][j]<c[i][j-1]){
        c[i][j] =c[i][j-1]; b[i][j] = 3;
      }
      else{
        c[i][j] =c[i][j-1];
        b[i][j] = 4;
      }
}
void LCS(int i,int j,char x[],int b[][100])
{
    if(i==0|| j==0)
     return ;
    if(b[i][j]==1)
    {
      LCS(i-1,j-1,x,b);cout<<x[i];
    }
    else if(b[i][j]==2)
    {
      LCS(i-1,j,x,b);
    }else if(b[i][j]==3)
      LCS(i,j-1,x,b);
     else {
      LCS(i-1,j,x,b);
      LCS(i,j-1,x,b);
     }

    }


int main(){
   int m,n;
   cin>>m>>n;
   int c[m][100];
   int b[m][100];
   char x[m],y[n];
   x[0] ='*';
   y[0] ='*';
   for(int i=1;i<=m;i++)
     cin>>x[i];
   for(int i=1;i<=n;i++)
     cin>>y[i];
   LCSLength(m,n,x,y,c,b);
   LCS(m,n,x,b);

}

